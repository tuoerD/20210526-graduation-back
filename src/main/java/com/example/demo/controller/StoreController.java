package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/demo/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * 获取商铺列表
     * @return
     */
    @PostMapping("getStoreList")
    public List<Store> getStoreList(){
        return storeService.getStoreList();
    }

}

