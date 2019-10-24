package com.company.gamestoreretail.servicelayer;

import com.company.gamestoreretail.model.Inventory;
import com.company.gamestoreretail.model.InvoiceItem;
import com.company.gamestoreretail.model.InvoiceViewModel;
import com.company.gamestoreretail.model.Product;
import com.company.gamestoreretail.util.feign.*;
import com.company.gamestoreretail.util.message.LevelViewModel;
import com.company.gamestoreretail.viewmodel.CustomerInvoiceViewModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RetailServiceLayer {

    private CustomerInvoiceViewModel civm;

    private CustomerFeignClient customerClient;

    private InventoryFeignClient inventoryClient;

    private InvoiceFeignClient invoiceClient;

    private LevelUpFeignClient levelUpClient;

    private ProductFeignClient productClient;


    @Transactional
    public CustomerInvoiceViewModel submitInvoice(InvoiceViewModel ivm) {
        ivm = invoiceClient.createInvoice(ivm);

        CustomerInvoiceViewModel civm = new CustomerInvoiceViewModel();
        civm.setInvoice_id(ivm.getInvoice_id());
        if(customerClient.getCustomer(ivm.getCustomer_id()) != null) {
            civm.setCustomer_id(ivm.getCustomer_id());
        } else {
            throw new IllegalArgumentException("Hey, this customer doesn't exist!");
        }
        civm.setPurchase_date(ivm.getPurchase_date());

        List<InvoiceItem> invoiceItems = ivm.getInvoiceItems();
        invoiceItems.forEach(i -> {
           if(inventoryClient.getInventory(i.getInventory_id()) == null) {
            throw new IllegalArgumentException("No inventory of the invoice item found.");
           } else {
               Inventory inventory = inventoryClient.getInventory(i.getInventory_id());
               Product product = productClient.getProduct(inventory.getProduct_id());
//               if(product.getList_price().compareTo(new BigDecimal("50.00")) > new BigDecimal("50.00")))
           }
        });
        civm.setInvoiceItems(ivm.getInvoiceItems());

        LevelViewModel levelPoints = levelUpClient.getLevelUpByCustomer(ivm.getCustomer_id());
        civm.setPoints(levelPoints.getPoints());

        return civm;

    }

    public List<CustomerInvoiceViewModel> getAllInvoicesByCustomerId(int customer_id) {
        return null;
    }

}
