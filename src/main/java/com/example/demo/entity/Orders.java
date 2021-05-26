package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Orders对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "orderId", type = IdType.AUTO)
    private Integer orderId;

    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "下单日期")
    @TableField("orderDate")
    private Date orderDate;

    @ApiModelProperty(value = "订单项的数量")
    @TableField("itemNumber")
    private Integer itemNumber;

    @ApiModelProperty(value = "订单总金额")
    @TableField("totalAmount")
    private Float totalAmount;


}
