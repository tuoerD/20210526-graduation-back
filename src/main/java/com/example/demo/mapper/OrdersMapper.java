package com.example.demo.mapper;

import com.example.demo.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.ordersVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    List<ordersVo> getOrdersInfo(Integer userId);
}
