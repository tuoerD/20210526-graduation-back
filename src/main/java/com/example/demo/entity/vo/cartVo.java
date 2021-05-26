package com.example.demo.entity.vo;

import lombok.Data;

@Data
public class cartVo {
    private Integer cartId;
    private String productName;
    private Float nowPrice;
    private Integer quantity;
}