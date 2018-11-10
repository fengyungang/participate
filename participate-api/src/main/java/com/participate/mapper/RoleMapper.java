package com.participate.mapper;

import com.participate.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 添加角色的方法
     * @param roleEntity
     * @return
     */
    int inserSysRole (SysRoleEntity roleEntity);

    /**
     * 根据编号获得对应的实体类
     * @param id
     * @return
     */
    SysRoleEntity byId(int id);

    /**
     * 删除角色的方法（物理删除）
     * @param entity
     */
    void delete(SysRoleEntity entity);

    /**
     *
     * @return
     */
    List<SysRoleEntity> getList();


}
