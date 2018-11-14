package com.participate.service;


import com.participate.entity.SysUserEntity;

import java.util.List;

public interface SysUserService {
    int addUser(SysUserEntity userEntity);

    List<SysUserEntity> getUserList();

    int deleteUser(long id);
}
