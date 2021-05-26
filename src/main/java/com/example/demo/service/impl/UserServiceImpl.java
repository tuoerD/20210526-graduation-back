package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getList() {
        return baseMapper.selectList(null);
    }

    /**
     * 用户登录
     * @param userEmail
     * @param password
     * @return
     */
    @Override
    public User login(String userEmail, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userEmail",userEmail);
        wrapper.eq("password",password);
        return baseMapper.selectOne(wrapper);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Boolean register(User user) {
        List<User> users = baseMapper.selectList(null);
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserEmail().equals(user.getUserEmail())){
                return false;
            }
        }
        baseMapper.insert(user);
        return true;
    }

    /**
     * 用户搜索（管理员操作）
     * @param searchKey
     * @param selectKey
     * @return
     */
    @Override
    public List<User> getUserListByKey(String searchKey,Integer selectKey) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        if(selectKey==1){
            wrapper.like("userId",searchKey);
        }else if (selectKey==2){
            wrapper.like("userName",searchKey);
        }else if (selectKey==3){
            wrapper.like("userEmail",searchKey);
        }else if (selectKey==4){
            wrapper.like("phoneNumber",searchKey);
        }else if(selectKey==5){
            wrapper.like("userAddress",searchKey);
        }else{
            wrapper.like("userEmail", searchKey).or()
                    .like("userName", searchKey).or()
                    .like("phoneNumber", searchKey)
                    .or().like("userAddress", searchKey);
        }
        return baseMapper.selectList(wrapper);
    }
//        wrapper.like("userEmail", searchKey).or().like("userName", searchKey).or().like("phoneNumber", searchKey).or().like("userAddress", searchKey);

    /**
     * 更新用户数据（修改用户信息时）
     */
    public User updateUserInfo(Integer userId){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        baseMapper.updateById(user);
        return user;
    }

    /**
     * 修改用户信息
     */
    @Override
    public Boolean editUserInfo(Integer userId, String userName, String phoneNumber, String userEmail, String userAddress) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        if(user.getDelTag()==1){
            return false;
        }
        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);
        user.setUserEmail(userEmail);
        user.setUserAddress(userAddress);
        baseMapper.updateById(user);
        return true;
    }

    /**
     * 用户禁用
     */
    @Override
    public Boolean deleteUser(Integer userId) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        if(user.getDelTag()==1){
            user.setDelTag(0);
        }
        else{
            user.setDelTag(1);
        }
        baseMapper.updateById(user);
        return true;
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     * @param newPsd
     * @return
     */
    @Override
    public Boolean changePassword(Integer userId, String password, String newPsd) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        if(user.getPassword().equals(password))
        {
            user.setPassword(newPsd);
            baseMapper.updateById(user);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 修改头像
     * @param file
     * @param userId
     * @return
     * @throws IOException
     */
    @Override
    public Boolean avatarChange(MultipartFile file, Integer userId) throws IOException {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        BASE64Encoder bEncoder=new BASE64Encoder();
        String[] suffixArra=file.getOriginalFilename().split("\\.");
        String preffix="data:image/jpg;base64,".replace("jpg", suffixArra[suffixArra.length - 1]);
        String base64EncoderImg=preffix + bEncoder.encode(file.getBytes()).replaceAll("[\\s*\t\n\r]", "");

        user.setUserImage(base64EncoderImg);
        baseMapper.updateById(user);
        return true;
    }

    @Override
    public User getUserById(Integer userId) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        return user;
    }
}
