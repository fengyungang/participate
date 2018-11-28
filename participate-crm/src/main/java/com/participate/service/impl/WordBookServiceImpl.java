package com.participate.service.impl;

import com.participate.dao.WordBookMapper;
import com.participate.entity.WordBookModel;
import com.participate.service.WordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordBookServiceImpl implements WordBookService {
    @Autowired
    private WordBookMapper wordBookMapper;
    @Override
    public int add(WordBookModel wordBookModel) {
        return wordBookMapper.add(wordBookModel);
    }

    @Override
    public WordBookModel getById(Integer id) {
        return wordBookMapper.getById(id);
    }

    @Override
    public List<WordBookModel> selA(WordBookModel wordBookModel) {
        return wordBookMapper.selA(wordBookModel);
    }

    @Override
    public int update(Integer word_book_id) {
        return wordBookMapper.update(word_book_id);
    }
}
