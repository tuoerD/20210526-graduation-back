package com.example.demo.service;

import com.example.demo.entity.Orderitem;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

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

    Boolean createOrderItems(Integer orderId, String productId, Integer productCount);
}
