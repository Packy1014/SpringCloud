package com.packy.springcloud.product_service.controller;

import com.packy.springcloud.product_service.domain.Product;
import com.packy.springcloud.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RefreshScope
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Value("${env}")
    private String env;

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
    public Product findById(@PathVariable int id) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Product product = new Product();
        BeanUtils.copyProperties(productService.findById(id), product);
        product.setName(product.getName() + " port: " + port + "| env: " + env);
        return product;
    }

}