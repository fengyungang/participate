package com.participate.service;

import com.participate.entity.DateStatisticsModel;

import java.util.List;
import java.util.Map;

public interface DateStatisticsService {
    /**
     * 添加方法
     * @param dateStatisticsModel
     * @return
     */
    int add(DateStatisticsModel dateStatisticsModel);

    /**
     * 根据id查询一条信息
     * @param date_statistics_id
     * @return
     */
    DateStatisticsModel getById(Integer date_statistics_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String,Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    List<DateStatisticsModel> selA(Map<String,Object> map);

    /**
     * 根据id修改某条信息
     * @param dateStatisticsModel
     * @return
     */
    int update(DateStatisticsModel dateStatisticsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param date_statistics_id
     * @return
     */
    int delById(Integer date_statistics_id);
}
