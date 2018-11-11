package com.packy.springcloud.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.packy.springcloud.order_service.service.ProductOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService, StringRedisTemplate stringRedisTemplate) {
        this.productOrderService = productOrderService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @PostMapping("orders")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Map<String, String> save(@RequestParam("userId") int userId, @RequestParam("productId") int productId, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String cookie = httpServletRequest.getHeader("cookie");
        System.err.println("token=" + token);
        System.err.println("cookie=" + cookie);

        Map<String, String> msg = new HashMap<>();
        msg.put("code", "0");
        msg.put("msg", "call save order successful, product id : " + productId + " user id : " + userId);
        productOrderService.save(userId, productId);
        return msg;
    }

    public Map<String, String> saveOrderFail(int userId, int productId, HttpServletRequest httpServletRequest) {
        //监控报警
        new Thread(() -> {
            String saveOrderKey = "save-order";
            String sendValue = stringRedisTemplate.opsForValue().get(saveOrderKey);
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("save order failed alarm");
                stringRedisTemplate.opsForValue().set(saveOrderKey, "sent", 10, TimeUnit.SECONDS);
            } else {
                System.out.println("save order failed alarm has been already sent");
            }
        }).start();

        Map<String, String> msg = new HashMap<>();
        msg.put("code", "-1");
        msg.put("msg", "call save order failed, product id : " + productId + " user id : " + userId);
        return msg;
    }
}
