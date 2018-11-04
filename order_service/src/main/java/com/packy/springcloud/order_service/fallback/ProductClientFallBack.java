package com.packy.springcloud.order_service.fallback;

import com.packy.springcloud.order_service.client.ProductClient;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallBack implements ProductClient {
    @Override
    public String findById(int id) {
        System.out.println("call product service failed");
        return "failed";
    }
}
