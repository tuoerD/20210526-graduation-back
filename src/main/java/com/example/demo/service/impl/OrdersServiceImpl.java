package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Orders;
import com.example.demo.entity.vo.ordersVo;
import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 获取订单列表
     * @return
     */
    @Override
    public List<Orders> getOrdersList() {
        return baseMapper.selectList(null);
    }

    /**
     * 获取订单信息（用户端）
     */
    @Override
    public List<ordersVo> getOrdersInfo(Integer userId) {
        List<ordersVo> list = ordersMapper.getOrdersInfo(userId);
        return list;
    }

    /**
     * 编辑订单状态
     * @param orderId
     * @param orderTag
     * @return
     */
    @Override
    public Boolean editOrderTag(Integer orderId, String orderTag) {
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders=baseMapper.selectOne(wrapper);
//        orders.setOrderTag(orderTag);
        baseMapper.updateById(orders);
        return true;
    }

    /**
     * 创建订单
     * @param neworder
     */
    @Override
    public void createOrder(Orders neworder) {
        baseMapper.insert(neworder);
        return;
    }

    @Override
    public Boolean deleteOrder(Integer orderId) {
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders order=baseMapper.selectOne(wrapper);
        if(order.getItemNumber()>1){
            order.setItemNumber(order.getItemNumber()-1);
            baseMapper.updateById(order);
            return true;
        }else {
            baseMapper.deleteById(orderId);
            return true;
        }
    }
}
