package com.example.demo.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class manageOrders {
    private Integer orderId;
    private Integer userId;
    private Date orderDate;
    private Integer orderItemId;
    private String productId;
    private Integer productCount;
    private String orderItemTag;
    private Float itemPay;
}
