package com.participate.mapper;

import com.participate.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(SysUserEntity userEntity);

    List<SysUserEntity> getUserList();
}
