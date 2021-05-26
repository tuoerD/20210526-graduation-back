package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Manager;
import com.example.demo.entity.User;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Override
    public List<Manager> getManagerList() {
        return baseMapper.selectList(null);
    }

    //管理员登录
    @Override
    public Manager managerLogin(String managerId, String managerPsd) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("managerId",managerId);
        wrapper.eq("managerPsd",managerPsd);
        return baseMapper.selectOne(wrapper);
    }
}
