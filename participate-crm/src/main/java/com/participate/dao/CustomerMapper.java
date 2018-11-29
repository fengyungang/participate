package com.participate.dao;

import com.participate.entity.CallLogModel;
import com.participate.entity.CustomerModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerMapper {
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
