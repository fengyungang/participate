package com.participate.service;

import com.participate.entity.SalesmanModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SalesmanService {
    /**
     * 添加方法
     * @param salesmanModel
     * @return
     */
    int add(SalesmanModel salesmanModel);

    /**
     * 根据id查询一条信息
     * @param salesman_id
     * @return
     */
    SalesmanModel getById(Integer salesman_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String,Object> map,Integer pageIndex,Integer pageSize);

    /**
     * 根据id修改某条信息
     * @param salesmanModel
     * @return
     */
    int update(SalesmanModel salesmanModel);

    /**
     * 根据销售人员id删除某条信息（物理删除）
     * @param salesman_id
     * @return
     */
    int delById(Integer salesman_id);
}
