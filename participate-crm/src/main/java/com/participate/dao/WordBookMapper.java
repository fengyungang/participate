package com.participate.dao;

import com.participate.entity.SalesmanModel;
import com.participate.entity.WordBookModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WordBookMapper {
    /**
     * 添加方法
     * @param wordBookModel
     * @return
     */
    int add(WordBookModel wordBookModel);

    /**
     * 根据id查询一条信息
     * @param id
     * @return
     */
    WordBookModel getById(Integer id);

    /**
     * 查询所有信息
     * @param wordBookModel
     * @return
     */
    List<WordBookModel> selA(WordBookModel wordBookModel);

    /**
     * 根据id修改某条信息
     * @param word_book_id
     * @return
     */
    int update(@Param("word_book_id") Integer word_book_id);
}
