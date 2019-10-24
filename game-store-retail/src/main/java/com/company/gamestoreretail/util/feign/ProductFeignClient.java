package com.company.gamestoreretail.util.feign;

import com.company.gamestoreretail.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductFeignClient {

    @GetMapping(value = "/products/{product_id}")
    public Product getProduct(@PathVariable int product_id);
}
