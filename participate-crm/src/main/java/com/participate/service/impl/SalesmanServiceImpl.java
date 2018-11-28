package com.participate.service.impl;

import com.participate.dao.SalesmanMapper;
import com.participate.entity.SalesmanModel;
import com.participate.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanServiceImpl implements SalesmanService {
    @Autowired
    private SalesmanMapper salesmanMapper;
    @Override
    public int add(SalesmanModel salesmanModel) {
        return salesmanMapper.add(salesmanModel);
    }

    @Override
    public SalesmanModel getById(Integer id) {
        return salesmanMapper.getById(id);
    }

    @Override
    public List<SalesmanModel> selA(SalesmanModel salesmanModel) {
        return salesmanMapper.selA(salesmanModel);
    }

    @Override
    public int update(Integer salesman_id) {
        return salesmanMapper.update(salesman_id);
    }
}
