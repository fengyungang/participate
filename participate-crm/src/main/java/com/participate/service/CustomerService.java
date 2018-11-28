package com.participate.service;

import com.participate.entity.CustomerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    List<CustomerModel> selA(CustomerModel customerModel);

    /**
     * 根据id修改某条信息
     * @param customer_id
     * @return
     */
    int update(@Param("customer_id") Integer customer_id);
}
