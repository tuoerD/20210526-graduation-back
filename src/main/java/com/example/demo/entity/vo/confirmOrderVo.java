package com.example.demo.entity.vo;

import lombok.Data;

@Data
public class confirmOrderVo {
    Integer cartId;
    String productId;
    String productName;
    Integer quantity;
    String picture;
    Float nowPrice;
}
