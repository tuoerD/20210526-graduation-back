package com.example.demo.mapper;

import com.example.demo.entity.Orderitem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.manageOrders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
//@Repository
public interface OrderitemMapper extends BaseMapper<Orderitem> {

    List<manageOrders> getManageOrders();
}
