package com.example.demo.mapper;

import com.example.demo.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.storeVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
public interface ProductMapper extends BaseMapper<Product> {
    storeVo getStoreInfo(String productId);
}
