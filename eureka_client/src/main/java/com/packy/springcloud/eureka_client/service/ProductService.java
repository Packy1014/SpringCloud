package com.packy.springcloud.eureka_client.service;

import com.packy.springcloud.eureka_client.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();

    Product findById(int id);
}
