package com.packy.springcloud.product_service.service.impl;

import com.packy.springcloud.product_service.domain.Product;
import com.packy.springcloud.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Product_1", 10, 100));
        productMap.put(2, new Product(2, "Product_2", 20, 200));
        productMap.put(3, new Product(3, "Product_3", 30, 300));
        productMap.put(4, new Product(4, "Product_4", 40, 400));
        productMap.put(5, new Product(5, "Product_5", 50, 500));
        productMap.put(6, new Product(6, "Product_6", 60, 600));
    }

    @Override
    public List<Product> listProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
