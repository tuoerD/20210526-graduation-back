package com.example.demo.controller;


import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.entity.vo.cartVo;
import com.example.demo.entity.vo.confirmOrderVo;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-17
 */
@RestController
@RequestMapping("/demo/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("getCartList")
    public List<Cart> getCartList(Integer userId){
        return cartService.getCartList(userId);
    }

    //获取购物车列表（用户）
    @PostMapping("getCartInfo/{userId}")
    public List<cartVo> getCartInfo(@PathVariable Integer userId){
        return cartService.getCartInfo(userId);
    }

    //加入购物车
    @PostMapping("addToCart")
    public int addToCart(Integer num,String productId,Integer userId){
        Cart cart=new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setQuantity(num);

        if(cartService.addToCart(cart)==false){
            return -1;
        }else  {
            return 1;
        }
    }

    /**
     * 删除购物车
     */
    @PostMapping("mutiDelete")
    public @ResponseBody Integer mutiDelete(@RequestBody List<Integer> ids){
        return cartService.mutiDelete(ids);
    }

    /**
     * 获取订单信息
     * @param cartId
     * @return
     */
    @PostMapping("getOrdersByCart")
    public confirmOrderVo getOrderByCart(Integer cartId){
//        List<confirmOrderVo> list=null;
//        for(int i=0;i<cartIds.size();i++){
//            int nowId=cartIds.get(i);
//            if(cartService.getOrderByCart(nowId)!=null){
//                list.add(cartService.getOrderByCart(nowId));
//            }
//        }
        return cartService.getOrderByCart(cartId);
    }

}

