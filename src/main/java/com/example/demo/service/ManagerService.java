package com.example.demo.service;

import com.example.demo.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
//@Service
public interface ManagerService extends IService<Manager> {

    List<Manager> getManagerList();

    Manager managerLogin(String managerId, String managerPsd);
}
