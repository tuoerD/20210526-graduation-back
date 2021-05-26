package com.example.demo.service;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
public interface UserService extends IService<User> {

    List<User> getList();

    //用户登录
    User login(String userEmail, String password);

    //用户注册
    Boolean register(User user);

    List<User> getUserListByKey(String searchKey, Integer selectKey);

    User updateUserInfo(Integer userId);

    Boolean editUserInfo(Integer userId, String userName, String phoneNumber, String userEmail, String userAddress);

    Boolean deleteUser(Integer userId);

    Boolean changePassword(Integer userId, String password, String newPsd);

    Boolean avatarChange(MultipartFile file, Integer userId) throws IOException;

    User getUserById(Integer userId);
}
