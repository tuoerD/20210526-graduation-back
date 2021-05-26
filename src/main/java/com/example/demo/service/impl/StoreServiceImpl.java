package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

    /**
     * 获取商铺列表
     * @return
     */
    @Override
    public List<Store> getStoreList() {
        return baseMapper.selectList(null);
    }
}
