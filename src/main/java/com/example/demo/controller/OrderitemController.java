package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Orderitem;
import com.example.demo.entity.vo.manageOrders;
import com.example.demo.mapper.OrderitemMapper;
import com.example.demo.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/demo/orderitem")
public class OrderitemController {
    @Autowired
    private OrderitemService orderitemService;

    /**
     * 创建订单项
     * @param orderId
     * @param productId
     * @param productCount
     * @return
     */
    @PostMapping("createOrderItems")
    public int createOrderItems(Integer orderId,String productId,Float nowPrice,Integer productCount){
        if(orderitemService.createOrderItems(orderId,productId,nowPrice,productCount)){
            return 1;
        }else {
            return -1;
        }

    }

    /**
     * 管理员获取订单项列表
     * @return
     */
    @PostMapping("getManageOrders")
    public List<manageOrders> getManageOrders(){
        return orderitemService.getManageOrders();
    }

    /**
     * 编辑订单项状态
     * @param orderItemId
     * @param orderItemTag
     * @return
     */
    @PostMapping("editOrderItemTag")
    public int editOrderItemTag(Integer orderItemId,String orderItemTag){
        if(orderitemService.editOrderItemTag(orderItemId,orderItemTag)==false){
            return -1;
        }
        else{
            return 1;
        }
    }

    @PostMapping("cancelOrderItem")
    public int  cancelOrderItem(Integer orderItemId){
        return orderitemService.cancelOrderItem(orderItemId);
    }

    @PostMapping("deleteOrderItem")
    public int deleteItem(Integer orderItemId){
        if(orderitemService.deleteOrderItem(orderItemId)){
            return 1;
        }else {
            return -1;
        }
    }
}

