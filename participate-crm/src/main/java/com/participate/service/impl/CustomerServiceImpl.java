package com.participate.service.impl;

import com.participate.dao.CustomerMapper;
import com.participate.entity.CustomerModel;
import com.participate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int add(CustomerModel customerModel) {
        return customerMapper.add(customerModel);
    }

    @Override
    public CustomerModel getById(Integer id) {
        return customerMapper.getById(id);
    }

    @Override
    public List<CustomerModel> selA(CustomerModel customerModel) {
        return customerMapper.selA(customerModel);
    }

    @Override
    public int update(Integer customer_id) {
        return customerMapper.update(customer_id);
    }
}
