package com.participate.service.Impl;

import com.participate.entity.SysUserEntity;
import com.participate.mapper.UserMapper;
import com.participate.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(SysUserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }

    @Override
    public List<SysUserEntity> getUserList() {
        return userMapper.getUserList();
    }
}
