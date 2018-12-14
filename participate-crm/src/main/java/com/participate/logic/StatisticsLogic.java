package com.participate.logic;

import com.participate.entity.DateStatisticsModel;
import com.participate.service.DateStatisticsService;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 统计业务逻辑层
 */
@Component
public class StatisticsLogic {
    @Autowired
    private DateStatisticsLogic dateStatisticsLogic;
    @Autowired
    private TimeStatisticsLogic imeStatisticsLogic;

    @Autowired
    private DateStatisticsService dateStatisticsService;
    /**
     * 查询前七天的数据统计，第一种方式
     * @return
     */
    public Result qiShowO() {

        Map<String ,Object> map = new HashMap<>();
        //取到前七天的数据
        map.put("startTime",DateUtils.getPastDate(7));
        map.put("endTime",DateUtils.getPastDate(1));
        List<DateStatisticsModel> dateStatisticsModelList = dateStatisticsService.selA(map);

        return Result.generate(0, "success", dateStatisticsModelList);
    }

    public Map<String,Object> oneLineDateSum(List<DateStatisticsModel> dateStatisticsModelList){
        Map<String,Object> map = new HashMap<>();
        //存储x轴信息
        Set<String> xDay = new HashSet<>();
        //存储y轴信息
        Map<String,Object> ySum = new HashMap<>();

        for (Iterator<DateStatisticsModel> iterator = dateStatisticsModelList.iterator(); iterator.hasNext(); ) {
            DateStatisticsModel next =  iterator.next();


        }

        return map;
    }

}
