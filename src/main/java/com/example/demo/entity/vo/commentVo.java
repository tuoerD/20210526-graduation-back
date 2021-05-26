package com.example.demo.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class commentVo {
    private Integer commentId;
    private Integer userId;
    private String productId;
    private String contentText;
    private Date time;
    private String userName;
    private String userImage;
}
