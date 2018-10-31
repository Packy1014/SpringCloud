package com.packy.springcloud.order_service.service.impl;

import com.packy.springcloud.order_service.domain.ProductOrder;
import com.packy.springcloud.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final RestTemplate restTemplate;

    @Autowired
    public ProductOrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductOrder save(int userId, int productId) {
        Map<String, Object> product = restTemplate.getForObject("http://product-service/api/v1/products/" + productId, Map.class);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProductName((String) product.get("name"));
        productOrder.setPrice((int) product.get("price"));
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setUserName("user");
        productOrder.setTradeNo(UUID.randomUUID().toString());
        return productOrder;
    }
}
