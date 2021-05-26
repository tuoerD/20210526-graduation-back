package com.example.demo.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ordersVo {
    private String orderDate;
    private String productName;
    private String storeName;
    private Float nowPrice;
    private Integer productCount;
    private String orderTag;
}
