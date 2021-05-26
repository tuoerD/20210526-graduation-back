package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
@RequestMapping("/demo/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("getList")
    public List<User> getList(){
       return userService.getList();
    }

    /**
     * 用户登录
     * @param userEmail
     * @param password
     * @return
     */
    @PostMapping("Login")
    public User login(String userEmail,String password){
        return userService.login(userEmail,password);
    }

    /**
     * 用户注册
     * @param userName
     * @param userEmail
     * @param phoneNumber
     * @param password
     * @return
     */
    @PostMapping("Register")
    public int register(String userName,String userEmail,String phoneNumber,String password){
        User user=new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);

        if(userService.register(user)==false){
            return -1;
        }
        else{
            return 1;
        }
    }

    /**
     * 用户搜索（管理员操作）
     * @param searchKey
     * @param selectKey
     * @return
     */
    @PostMapping("getUserListByKey")
    public List<User> getUserListByKey(String searchKey,Integer selectKey){
        return userService.getUserListByKey(searchKey,selectKey);
    }

    /**
     * 更新用户数据(修改用户信息时)
     */
    @PostMapping("updateUserInfo")
    public User updateUserInfo(Integer userId){
        return userService.updateUserInfo(userId);
    }

    /**
     * 修改用户信息
     */
    @PostMapping("editUserInfo")
    public int editUserInfo(Integer userId,String userName,String phoneNumber,String userEmail,String userAddress){
        if(userService.editUserInfo(userId,userName,phoneNumber,userEmail,userAddress)==false){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * 用户禁用
     */
    @PostMapping("deleteUser")
    public int deleteUser(Integer userId){
        if(userService.deleteUser(userId)){
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     * @param newPsd
     * @return
     */
    @PostMapping("changePassword")
    public int changePassword(Integer userId,String password,String newPsd){
        if(userService.changePassword(userId,password,newPsd))
        {
            return 1;
        }else {
            return -1;
        }

    }

    /**
     * 修改头像
     * @param file
     * @param userId
     * @return
     * @throws IOException
     */
    @PostMapping("UserAvatar")
    public int avatarChange(@RequestParam("file") MultipartFile file, Integer userId) throws IOException {
        if(userService.avatarChange(file,userId)){
            return 1;
        }else{
            return -1;
        }
    }

    @PostMapping("getUserById")
    public User getUserById(Integer userId){
        return userService.getUserById(userId);
    }

}

