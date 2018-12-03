package com.participate.service;

import com.participate.entity.WordBookModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WordBookService {
    /**
     * 添加方法
     * @param wordBookModel
     * @return
     */
    int add(WordBookModel wordBookModel);

    /**
     * 根据id查询一条信息
     * @param word_book_id
     * @return
     */
    WordBookModel getById(Integer word_book_id);

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
     * @param wordBookModel
     * @return
     */
    int update(WordBookModel wordBookModel);

    /**
     * 根据id删除字典表信息（物理删除）
     * @param word_book_id
     * @return
     */
    int delById(Integer word_book_id);
}
