package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.vo.cartVo;
import com.example.demo.entity.vo.confirmOrderVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-17
 */
//@Service
public interface CartService extends IService<Cart> {

    List<Cart> getCartList(Integer userId);

    List<cartVo> getCartInfo(Integer userId);

    Boolean addToCart(Cart cart);

    Integer mutiDelete(List<Integer> ids);

    confirmOrderVo getOrderByCart(Integer cartId);
}
