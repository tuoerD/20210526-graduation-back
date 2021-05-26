package com.example.demo.mapper;

import com.example.demo.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.cartVo;
import com.example.demo.entity.vo.confirmOrderVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-17
 */
//@Repository
public interface CartMapper extends BaseMapper<Cart> {
    List<cartVo> getCartInfo(Integer userId);

    confirmOrderVo getOrderByCart(int cartId);
}
