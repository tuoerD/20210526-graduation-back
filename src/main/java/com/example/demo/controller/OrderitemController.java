package com.example.demo.controller;


import com.example.demo.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/demo/orderitem")
public class OrderitemController {
    @Autowired
    private OrderitemService orderitemService;

    @PostMapping("createOrderItems")
    public int createOrderItems(Integer orderId,String productId,Integer productCount){
        if(orderitemService.createOrderItems(orderId,productId,productCount)){
            return 1;
        }else {
            return -1;
        }

    }
}

