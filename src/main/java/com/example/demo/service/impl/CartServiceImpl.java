package com.example.demo.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.vo.confirmOrderVo;
import com.example.demo.mapper.CartMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Cart;
import com.example.demo.entity.vo.cartVo;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-17
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 获取购物车列表
     * @param userId
     * @return
     */
    @Override
    public List<Cart> getCartList(Integer userId) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.eq("userId",userId);
        return baseMapper.selectList(wrapper);
    }

    /**
     * 根据用户ID获取购物车信息
     * @param userId
     * @return
     */
    @Override
    public List<cartVo> getCartInfo(Integer userId) {
        List<cartVo> list =  cartMapper.getCartInfo(userId);
        return list;
    }

    /**
     * 加入购物车
     * @param cart
     * @return
     */
    @Override
    public Boolean addToCart(Cart cart) {
        baseMapper.insert(cart);
        return true;
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public Integer mutiDelete(List<Integer> ids) {
        baseMapper.deleteBatchIds(ids);
        return 1;
    }

    /**
     * 获取订单信息
     * @param cartId
     * @return
     */
    @Override
    public confirmOrderVo getOrderByCart(Integer cartId) {
        confirmOrderVo conOrder=cartMapper.getOrderByCart(cartId);
        return conOrder;
    }
}
