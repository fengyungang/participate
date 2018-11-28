package com.participate.service;

import com.participate.entity.CallLogModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CallLogService {
    /**
     * 添加方法
     * @param callLogModel
     * @return
     */
    int add(CallLogModel callLogModel);

    /**
     * 根据id查询一条信息
     * @param id
     * @return
     */
    CallLogModel getById(Integer id);

    /**
     * 查询所有信息
     * @param callLogModel
     * @return
     */
    List<CallLogModel> selA(CallLogModel callLogModel);

    /**
     * 根据id修改某条信息
     * @param call_log_id
     * @return
     */
    int update(@Param("call_log_id") Integer call_log_id);

}
