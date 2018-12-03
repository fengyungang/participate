package com.participate.logic;

import com.participate.entity.WordBookModel;
import com.participate.service.WordBookService;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 字典表业务逻辑层
 */
@Component
public class WordBookLogic {
    @Autowired
    private WordBookService wordBookService;
    /**
     * 添加字典表信息
     * @param wordBookModel
     * @return
     */
    public Result add(WordBookModel wordBookModel){
        wordBookModel.setWord_book_create_time(new Date());
        wordBookModel.setWord_book_update_time(new Date());
        int res = wordBookService.add(wordBookModel);
        return Result.generate(0,"add wordBook success",wordBookModel);
    }

    /**
     * 根据字典表主键id查询一条字典表信息
     * @param word_book_id
     * @return
     */
    public Result getById(Integer word_book_id){
       WordBookModel wordBookModel =  wordBookService.getById(word_book_id);
       return  Result.generate(0,"selsect wordBook success",wordBookModel);
    }

    /**
     * 查询字典表信息列表（可按条件模糊查询）
     * @param customer_id
     * @param salesman_id
     * @param word_book_contact_state
     * @param word_book_customer_satisfaction
     * @param word_book_create_time
     * @param word_book_update_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selA(Integer customer_id,Integer salesman_id,Integer word_book_contact_state ,Integer word_book_customer_satisfaction,String word_book_create_time,String word_book_update_time,Integer pageIndex,Integer pageSize){
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("customer_id",customer_id);
        map.put("salesman_id",salesman_id);
        map.put("word_book_contact_state",word_book_contact_state);
        map.put("word_book_customer_satisfaction",word_book_customer_satisfaction);
        if (word_book_create_time!=null&&!"".equals(word_book_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("word_book_create_time", DateUtils.StD(word_book_create_time,"yyyy-MM-dd"));
        }
        if (word_book_update_time!=null&&!"".equals(word_book_update_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("word_book_update_time", DateUtils.StD(word_book_update_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select wordBook success",wordBookService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据字典表id更改字典表信息
     * @param wordBookModel
     * @return
     */
    public Result update(WordBookModel wordBookModel){
        wordBookModel.setWord_book_update_time(new Date());
        int res =  wordBookService.update(wordBookModel);
        if (res<0){
            return Result.generate(1,"update wordBook fail ",null);
        }
        return  Result.generate(0,"update wordBook success",wordBookModel);
    }

    /**
     * 根据字典表主键id删除字典表信息（物理删除）
     * @param word_book_id
     * @return
     */
    public Result delById(Integer word_book_id){
       int res =  wordBookService.delById(word_book_id);
       if (res<0){
           return Result.generate(1,"delete wordBoook fail",null);
       }
        return  Result.generate(0,"delete wordBook success",res);
    }
}
