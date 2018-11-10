package com.participate.mapper;

import com.participate.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 添加用户的方法
     * @param userEntity
     * @return
     */
    int insertUser(SysUserEntity userEntity);

    /**
     * 获得用户的方法
     * @return
     */
    List<SysUserEntity> getUserList();
}
