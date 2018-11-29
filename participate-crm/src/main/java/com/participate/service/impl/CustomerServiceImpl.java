package com.participate.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.CustomerMapper;
import com.participate.entity.CustomerModel;
import com.participate.service.CustomerService;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 添加方法
     * @param customerModel
     * @return
     */
    @Override
    public int add(CustomerModel customerModel) {
        return customerMapper.add(customerModel);
    }

    /**
     * 根据id查询一条信息
     * @param id
     * @return
     */
    @Override
    public CustomerModel getById(Integer id) {
        return customerMapper.getById(id);
    }

    /**
     * 查询所有信息
     * @param customerModel
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> selA(CustomerModel customerModel, Integer pageIndex, Integer pageSize) {

        Map<String,Object> map = new HashMap<>();

        PageHelper.startPage(pageIndex,pageSize);
        List<CustomerModel> customerModelList = customerMapper.selA(customerModel);
        PageInfo<CustomerModel> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        map.put("customerModelList",customerModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 根据id修改某条信息
     * @param customerModel
     * @return
     */
    @Override
    public int update(CustomerModel customerModel) {
        return customerMapper.update(customerModel);
    }

    /**
     * -根据id删除客户信息（物理删除）
     * @param id
     * @return
     */
    @Override
    public int delById(Integer id) {
        return customerMapper.delById(id);
    }
}
