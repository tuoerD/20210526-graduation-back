package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "productId", type = IdType.ID_WORKER)
    private String productId;

    @ApiModelProperty(value = "商品名称")
    @TableField("productName")
    private String productName;

    @ApiModelProperty(value = "原价")
    @TableField("startPrice")
    private Float startPrice;

    @ApiModelProperty(value = "现价")
    @TableField("nowPrice")
    private Float nowPrice;

    @ApiModelProperty(value = "商品库存")
    private Integer inventory;

    @ApiModelProperty(value = "图片")
    private String picture;

    @ApiModelProperty(value = "店铺编号")
    @TableField("storeId")
    private Integer storeId;

    @ApiModelProperty(value = "产品类型")
    private String type;

    @ApiModelProperty(value = "产品销量")
    @TableField("salesVolume")
    private Integer salesVolume;

}
