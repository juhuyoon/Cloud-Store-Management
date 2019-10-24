package com.company.gamestoreretail.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("product-service")
public interface ProductFeignClient {
}
