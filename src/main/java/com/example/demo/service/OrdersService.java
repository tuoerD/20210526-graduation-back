package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.vo.ordersVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
public interface OrdersService extends IService<Orders> {

    List<Orders> getOrdersList();

    List<ordersVo> getOrdersInfo(Integer userId);

    Boolean editOrderTag(Integer orderId,String orderTag);

    void createOrder(Orders neworder);
}
