package com.packy.springcloud.order_service.controller;

import com.packy.springcloud.order_service.domain.ProductOrder;
import com.packy.springcloud.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping("orders")
    public ProductOrder save(@RequestParam("userId") int userId, @RequestParam("productId") int productId) {
        return productOrderService.save(userId, productId);
    }
}
