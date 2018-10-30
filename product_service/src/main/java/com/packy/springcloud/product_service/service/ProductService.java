package com.packy.springcloud.product_service.service;

import com.packy.springcloud.product_service.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();

    Product findById(int id);
}
