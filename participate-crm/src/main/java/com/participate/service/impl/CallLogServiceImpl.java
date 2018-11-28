package com.participate.service.impl;

import com.participate.dao.CallLogMapper;
import com.participate.entity.CallLogModel;
import com.participate.service.CallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CallLogServiceImpl implements CallLogService {
    @Autowired
    private CallLogMapper callLogMapper;
    @Override
    public int add(CallLogModel callLogModel) {
        return callLogMapper.add(callLogModel);
    }

    @Override
    public CallLogModel getById(Integer id) {
        return callLogMapper.getById(id);
    }

    @Override
    public List<CallLogModel> selA(CallLogModel callLogModel) {
        return callLogMapper.selA(callLogModel);
    }

    @Override
    public int update(Integer call_log_id) {
        return callLogMapper.update(call_log_id);
    }
}
