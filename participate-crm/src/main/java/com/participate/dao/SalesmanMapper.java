package com.participate.dao;

import com.participate.entity.CustomerModel;
import com.participate.entity.SalesmanModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SalesmanMapper {
    /**
     * 添加方法
     * @param salesmanModel
     * @return
     */
    int add(SalesmanModel salesmanModel);

    /**
     * 根据id查询一条信息
     * @param id
     * @return
     */
    SalesmanModel getById(Integer id);

    /**
     * 查询所有信息
     * @param salesmanModel
     * @return
     */
    List<SalesmanModel> selA(SalesmanModel salesmanModel);

    /**
     * 根据id修改某条信息
     * @param salesman_id
     * @return
     */
    int update(@Param("salesman_id") Integer salesman_id);
}

