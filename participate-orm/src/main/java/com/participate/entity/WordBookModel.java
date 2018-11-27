package com.participate.entity;

import lombok.Data;

import java.util.Date;

/**
 * 字典表
 * WordBook的model，对应word_book表
 */
@Data
public class WordBookModel {
    private Integer word_book_id;//字典表主键id
    private Integer customer_id;//客户id（关联外键）
    private Integer salesman_id;//销售人员id（关联外键）
    private Integer word_book_contact_state;//联系状态（0未联系，1联系过）
    //很不满意、不满意、一般、满意和很满意1-5
    private Integer word_book_customer_satisfaction;//客户满意度（1-5）
    private Date word_book_create_time;//创建时间
    private Date word_book_update_time;//更新时间
}
