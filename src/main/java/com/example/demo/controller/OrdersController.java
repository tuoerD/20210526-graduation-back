package com.example.demo.controller;


import com.example.demo.entity.Orders;
import com.example.demo.entity.vo.ordersVo;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
@RestController
@RequestMapping("/demo/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 获取订单列表
     * @return
     */
    @PostMapping("getOrdersList")
    public List<Orders> getOrdersList(){
        return ordersService.getOrdersList();
    }

    /**
     * 获取订单信息（用户端）
     */
    @PostMapping("getOrdersInfo/{userId}")
    public List<ordersVo> getOrdersInfo(@PathVariable Integer userId){
        return ordersService.getOrdersInfo(userId);
    }

    /**
     * 编辑订单状态
     * @param orderId
     * @param orderTag
     * @return
     */
    @PostMapping("editOrderTag")
    public int editOrderTag(Integer orderId,String orderTag){
        if(ordersService.editOrderTag(orderId,orderTag)==false){
            return -1;
        }
        else{
            return 1;
        }
    }

    /**
     * 创建订单
     * @param userId
     * @param itemNumber
     * @param totalAmount
     * @return
     */
    @PostMapping("createOrder")
    public Orders createOrder(Integer userId, Integer itemNumber, Float totalAmount){
        Orders neworder=new Orders();
        neworder.setUserId(userId);
        neworder.setItemNumber(itemNumber);
        neworder.setTotalAmount(totalAmount);
        Date date = new Date();
        neworder.setOrderDate(date);
        ordersService.createOrder(neworder);
        return neworder;
    }

    @PostMapping("deleteOrder")
    public int deleteOrder(Integer orderId){
        if(ordersService.deleteOrder(orderId)){
            return 1;
        }else {
            return -1;
        }
    }

}

