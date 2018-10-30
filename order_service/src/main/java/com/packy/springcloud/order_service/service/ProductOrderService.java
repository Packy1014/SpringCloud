package com.packy.springcloud.order_service.service;

import com.packy.springcloud.order_service.domain.ProductOrder;

public interface ProductOrderService {
    ProductOrder save(int userId, int productId);
}
