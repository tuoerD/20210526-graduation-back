package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Orderitem;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.entity.vo.manageOrders;
import com.example.demo.mapper.OrderitemMapper;
import com.example.demo.service.OrderitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private OrderitemMapper orderitemMapper;

    /**
     * 创建订单项
     * @param orderId
     * @param productId
     * @param productCount
     * @return
     */
    @Override
    public Boolean createOrderItems(Integer orderId, String productId ,Float nowPrice, Integer productCount) {
        Orderitem newOrderItem=new Orderitem();
        newOrderItem.setOrderId(orderId);
        newOrderItem.setProductId(productId);
        newOrderItem.setProductCount(productCount);
        newOrderItem.setItemPay(nowPrice*productCount);
        baseMapper.insert(newOrderItem);
        return true;
    }

    /**
     * 管理员获取订单项列表
     * @return
     */
    @Override
    public List<manageOrders> getManageOrders() {
        return orderitemMapper.getManageOrders();
    }

    /**
     * 编辑订单项状态
     * @param orderItemId
     * @param orderItemTag
     * @return
     */
    @Override
    public Boolean editOrderItemTag(Integer orderItemId, String orderItemTag) {
        QueryWrapper<Orderitem> wrapper=new QueryWrapper<>();
        wrapper.eq("orderItemId",orderItemId);
        Orderitem orderitem=baseMapper.selectOne(wrapper);
        orderitem.setOrderItemTag(orderItemTag);
        baseMapper.updateById(orderitem);
        return true;
    }

    /**
     * 取消订单前获取订单号
     * @param orderItemId
     * @return
     */
    @Override
    public int cancelOrderItem(Integer orderItemId) {
//        int orderid=0;
        QueryWrapper<Orderitem> wrapper=new QueryWrapper<>();
        wrapper.eq("orderItemId",orderItemId);
        Orderitem item=baseMapper.selectOne(wrapper);

        return item.getOrderId();
//        baseMapper.deleteById(orderItemId);
    }

    /**
     * 删除订单项
     * @param orderItemId
     * @return
     */
    @Override
    public Boolean deleteOrderItem(Integer orderItemId) {
        baseMapper.deleteById(orderItemId);
        return true;
    }

    @Override
    public List<manageOrders> getOrderitemsListByKey(List list,String searchKey, Integer selectKey) {

        return null;
    }
}
