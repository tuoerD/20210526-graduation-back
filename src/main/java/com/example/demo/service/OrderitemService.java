package com.example.demo.service;

import com.example.demo.entity.Orderitem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.vo.manageOrders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
//@Service
public interface OrderitemService extends IService<Orderitem> {

    Boolean createOrderItems(Integer orderId, String productId ,Float nowPrice, Integer productCount);

    List<manageOrders> getManageOrders();

    Boolean editOrderItemTag(Integer orderItemId, String orderItemTag);

    int cancelOrderItem(Integer orderItemId);

    Boolean deleteOrderItem(Integer orderItemId);
}
