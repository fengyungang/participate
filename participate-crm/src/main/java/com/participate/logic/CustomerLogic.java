package com.participate.logic;


import com.participate.entity.CustomerModel;
import com.participate.service.CustomerService;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户业务逻辑层
 */
@Component
public class CustomerLogic {
    @Autowired
    private CustomerService customerService;

    /**
     * 添加客户信息
     * @param customerModel
     * @return
     */
    public Result add(CustomerModel customerModel){
        int res = customerService.add(customerModel);
        return Result.generate(0,"add customer success",res);
    }

    /**
     * 根据客户id查询客户信息
     * @param id
     * @return
     */
    public Result getById(Integer id){
        CustomerModel customerModel =  customerService.getById(id);
        return Result.generate(0,"select customer success",customerModel);
    }

    /**
     * 查询所有客户的信息列表
     * @param customerModel
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(CustomerModel customerModel,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        return Result.generate(1,"select customer success",customerService.selA(customerModel,pageIndex,pageSize));
    }

    /**
     * 根据客户id修改客户信息
     * @param customerModel
     * @return
     */
    public Result updCustomer(CustomerModel customerModel){
        int res = customerService.update(customerModel);
        if (res<0){
            return Result.generate(1,"update customer fail ",null);
        }
        return Result.generate(0,"update customer success",res);
    }

    /**
     * 在逻辑上删除客户信息
      * @return customer_id
     */
    public Result delCustomer(Integer customer_id){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomer_del(1);
        customerService.update(customerModel);
        return Result.generate(0,"delet customer success",null);
    }
}