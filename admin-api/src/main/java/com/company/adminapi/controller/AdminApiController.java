package com.company.adminapi.controller;

import com.company.adminapi.dto.Inventory;
import com.company.adminapi.dto.Product;
import com.company.adminapi.util.feign.InventoryClient;
import com.company.adminapi.util.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class AdminApiController {
    private final InventoryClient inventoryClient;
    private final ProductClient productClient;

    @Autowired
    AdminApiController(InventoryClient inventoryClient, ProductClient productClient){
        this.inventoryClient = inventoryClient;
        this.productClient = productClient;
    }

    @RequestMapping(value="/inventory/{id}", method = RequestMethod.GET)
    public Inventory getInventory(@PathVariable int id)throws Exception{
        Inventory inventory = inventoryClient.getInventory(id);
        if (inventory == null) {
            throw new Exception("Inventory not found.");
        }
        return inventory;
    }

    @RequestMapping(value="/inventory", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory createInventory (@RequestBody @Valid Inventory inventory) throws Exception {
        return inventoryClient.createInventory(inventory);
    }

    @RequestMapping(value="/inventory", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateInventory(@RequestBody @Valid Inventory inventory) {
        inventoryClient.updateInventory(inventory);
    }

    @RequestMapping(value="/inventory/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInventory(@PathVariable int id) {
        inventoryClient.deleteInventory(id);
    }

    @RequestMapping(value="/inventory", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Inventory> getAllInventory() {
        return inventoryClient.getInventoryList();
    }


    //@PostMapping
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody @Valid Product product) {
        return productClient.createProduct(product);

    }

    //@DeleteMapping(path = "/{product_id}")
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int product_id) {
        productClient.deleteProduct(product_id);
    }

    //@GetMapping
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Product> getProductList() {
        return productClient.getProductList();

    }

    //@GetMapping(path = "/{id}")
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Product getProduct(@PathVariable int id) throws Exception {
        Product product = productClient.getProduct(id);
        if (product == null) {
            throw new Exception("Product not found.");
        }
        return product;

    }

    //@PutMapping
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody @Valid Product product) {
        productClient.updateProduct(product);

    }


}
