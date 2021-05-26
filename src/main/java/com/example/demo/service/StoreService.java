package com.example.demo.service;

import com.example.demo.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
public interface StoreService extends IService<Store> {
    List<Store> getStoreList();
}
