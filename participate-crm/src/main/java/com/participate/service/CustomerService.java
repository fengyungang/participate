package com.participate.service;

import com.participate.entity.CustomerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    /**
     * 添加方法
     * @param customerModel
     * @return
     */
    int add(CustomerModel customerModel);

    /**
     * 根据id查询一条信息
     * @param id
     * @return
     */
    CustomerModel getById(Integer id);

    /**
     * 查询所有信息
     * @param customerModel
     * @return
     */
    Map<String,Object> selA(CustomerModel customerModel, Integer pageIndex, Integer pageSize);

    /**
     * 根据id修改某条信息
     * @param customerModel
     * @return
     */
    int update(CustomerModel customerModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param id
     * @return
     */
    int delById(Integer id);
}
