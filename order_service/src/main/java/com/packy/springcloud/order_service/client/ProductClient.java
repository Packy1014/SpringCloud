package com.packy.springcloud.order_service.client;

import com.packy.springcloud.order_service.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", fallback = ProductClientFallBack.class)
public interface ProductClient {
    @GetMapping("/api/v1/products/{id}")
    String findById(@PathVariable(value = "id") int id);
}
