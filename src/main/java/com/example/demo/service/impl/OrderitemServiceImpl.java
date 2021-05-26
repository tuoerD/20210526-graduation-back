package com.example.demo.service.impl;

import com.example.demo.entity.Orderitem;
import com.example.demo.mapper.OrderitemMapper;
import com.example.demo.service.OrderitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@Service
public class OrderitemServiceImpl extends ServiceImpl<OrderitemMapper, Orderitem> implements OrderitemService {
    @Override
    public Boolean createOrderItems(Integer orderId, String productId, Integer productCount) {
        Orderitem newOrderItem=new Orderitem();
        newOrderItem.setOrderId(orderId);
        newOrderItem.setProductId(productId);
        newOrderItem.setProductCount(productCount);
        baseMapper.insert(newOrderItem);
        return true;
    }
}
