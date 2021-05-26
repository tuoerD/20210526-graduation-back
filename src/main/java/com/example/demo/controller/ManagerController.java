package com.example.demo.controller;


import com.example.demo.entity.Manager;
import com.example.demo.entity.User;
import com.example.demo.service.ManagerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/demo/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @GetMapping("getManagerList")
    public List<Manager> getManagerList(){
        return managerService.getManagerList();
    }

    //管理员登录
    @PostMapping("managerLogin")
    public Manager login(String managerId,String managerPsd){
        return managerService.managerLogin(managerId,managerPsd);
    }
}

