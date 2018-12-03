package com.participate.logic;


import com.alibaba.fastjson.JSONObject;
import com.participate.entity.CustomerModel;
import com.participate.service.CustomerService;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
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
        customerModel.setCustomer_create_time(new Date());
        int res = customerService.add(customerModel);

        return Result.generate(0,"add customer success",customerModel);
    }

    /**
     * 根据客户id查询客户信息
     * @param customer_id
     * @return
     */
    public Result getById(Integer customer_id){
        CustomerModel customerModel =  customerService.getById(customer_id);
        return Result.generate(0,"select customer success",customerModel);
    }

    /**
     * 查询所有客户的信息列表（可按条件模糊查询）
     * @param salesman_id
     * @param customer_name
     * @param customer_phone_number
     * @param customer_sex
     * @param customer_del
     * @param customer_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer salesman_id, String customer_name, String customer_phone_number,String customer_sex,Integer customer_del, String customer_create_time,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("salesman_id",salesman_id);
        map.put("customer_name",customer_name);
        map.put("customer_phone_number",customer_phone_number);
        map.put("customer_sex",customer_sex);
        map.put("customer_del",customer_del);
        if (customer_create_time!=null&&!"".equals(customer_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("customer_create_time", DateUtils.StD(customer_create_time,"yyyy-MM-dd"));
        }

        return Result.generate(1,"select customer success",customerService.selA(map,pageIndex,pageSize));
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
        return Result.generate(0,"update customer success",customerModel);
    }

    /**
     * 在逻辑上删除客户信息
      * @return customer_id
     */
    public Result delCustomer(Integer customer_id){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomer_id(customer_id);
        customerModel.setCustomer_del(1);
        customerService.update(customerModel);
        return Result.generate(0,"delet customer success",customerModel);
    }

    /**
     * 根据销售id查看自己底下的客户信息功能
     * @param salesman_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public  Result salesmanGetByCustomer(Integer salesman_id,Integer pageIndex,Integer pageSize){
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("salesman_id",salesman_id);

        return Result.generate(1,"select customer success",customerService.selA(map,pageIndex,pageSize));
    }

    /**
     * 销售与销售之间转让客户信息
     * @param customer_id
     * @param salesman_id
     * @return
     */
    public Result salesmanGiveWay(Integer customer_id,Integer salesman_id){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomer_id(customer_id);
        customerModel.setSalesman_id(salesman_id);
        int res = customerService.update(customerModel);
        if (res<0){
            return Result.generate(1,"update customer fail ",null);
        }
        return Result.generate(0,"update customer success",customerModel);
    }

}