package com.packy.springcloud.eureka_client.controller;

import com.packy.springcloud.eureka_client.domain.Product;
import com.packy.springcloud.eureka_client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("products/{id}")
    public Product fingById(@PathVariable int id) {
        return productService.findById(id);
    }

}
