package com.participate.service;

import com.participate.entity.CallLogModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CallLogService {
    /**
     * 添加方法
     * @param callLogModel
     * @return
     */
    int add(CallLogModel callLogModel);

    /**
     * 根据id查询一条信息
     * @param call_log_id
     * @return
     */
    CallLogModel getById(Integer call_log_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String,Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 根据id修改某条信息
     * @param callLogModel
     * @return
     */
    int update(CallLogModel callLogModel);

}
