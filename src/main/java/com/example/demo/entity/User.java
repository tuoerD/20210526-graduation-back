package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    @TableField("userName")
    private String userName;

    @TableField("userEmail")
    private String userEmail;

    @TableField("phoneNumber")
    private String phoneNumber;

    private String password;

    @TableField("userAddress")
    private String userAddress;

    @ApiModelProperty(value = "是否禁用该用户")
    @TableField("delTag")
    private Integer delTag;

    @ApiModelProperty(value = "用户头像")
    @TableField("userImage")
    private String userImage;
}
