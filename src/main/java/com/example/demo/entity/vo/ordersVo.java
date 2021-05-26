package com.example.demo.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ordersVo {
    private String orderDate;
    private String productName;
    private String storeName;
    private Integer productCount;
    private Float itemPay;
    private String orderItemTag;
}
