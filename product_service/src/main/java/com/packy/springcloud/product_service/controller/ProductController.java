package com.packy.springcloud.product_service.controller;

import com.packy.springcloud.product_service.domain.Product;
import com.packy.springcloud.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Value("${server.port}")
    private String port;

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
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Product product =new Product();
        BeanUtils.copyProperties(productService.findById(id), product);
        product.setName(product.getName() + " port: " + port);
        return product;
    }

}