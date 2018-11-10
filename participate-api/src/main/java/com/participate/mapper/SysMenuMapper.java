package com.participate.mapper;

import com.participate.entity.SysMenuEntity;

public interface SysMenuMapper {
    /**
     * 添加菜单的方法
     * @param entity
     * @return
     */
    int inserSysMenu(SysMenuEntity entity);

    /**
     * 根据编号获得对应的实体类
     * @param id
     * @return
     */
    SysMenuEntity byId (int id);
}
