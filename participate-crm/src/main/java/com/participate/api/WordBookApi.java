package com.participate.api;

import com.participate.entity.WordBookModel;
import com.participate.logic.WordBookLogic;
import com.participate.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典表api层
 */
@io.swagger.annotations.Api(value="wordBook接口", tags="wordBook接口")
@RestController
@RequestMapping("api/wordBook")
public class WordBookApi extends BaseApi{
    @Autowired
    private WordBookLogic wordBookLogic;

    /**
     * 添加字典表信息
     * @param token
     * @param wordBookModel
     * @return
     */
    @ApiOperation(value = "新增字典表信息",notes = "addWordBookr接口的添加字典表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表id（关联外键）", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "word_book_contact_state", value = "联系状态（0未联系，1联系过）", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "word_book_customer_satisfaction", value = "客户满意度（0为最差,0-5）", required = false, dataType = "Integer", paramType = "form")

    })
    @ResponseBody
    @PostMapping("/addWordBook")
    public Result addWordBook(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              WordBookModel wordBookModel)
    {
        return wordBookLogic.add(wordBookModel);
    }

    /**
     * 查询字典表列表信息（可按条件模糊查询）
     * @param token
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
    @ApiOperation(value = "查询字典表列表信息（可按条件模糊查询）",notes = "selAWordBook接口的查询字典表列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表id（关联外键）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "word_book_contact_state", value = "联系状态（0未联系，1联系过）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "word_book_customer_satisfaction", value = "客户满意度（0为最差,0-5）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "word_book_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "word_book_update_time", value = "更新时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selAWordBook")
    public Result selAWordBook(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              Integer customer_id, Integer salesman_id, Integer word_book_contact_state,Integer word_book_customer_satisfaction, String word_book_create_time,String word_book_update_time,Integer pageIndex,Integer pageSize)
    {
        return wordBookLogic.selA(customer_id,salesman_id,word_book_contact_state,word_book_customer_satisfaction,word_book_create_time,word_book_update_time,pageIndex,pageSize);
    }

    /**
     * 根据id查询单条字典表信息
     * @param token
     * @param word_book_id
     * @return
     */
    @ApiOperation(value = "根据id查询单条字典表信息",notes = "selOWordBook接口的根据id查询单条字典表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word_book_id", value = "字典表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selOWordBook")
    public Result selOWordBook(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              Integer word_book_id)
    {
        return wordBookLogic.getById(word_book_id);
    }

    /**
     * 根据字典表主键id修改字典表信息
     * @param token
     * @param wordBookModel
     * @return
     */
    @ApiOperation(value = "根据字典表主键id修改字典表信息",notes = "updWordBook接口的修改字典表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word_book_id", value = "字典表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/updWordBook")
    public Result updWordBook(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                             WordBookModel wordBookModel)
    {
        return wordBookLogic.update(wordBookModel);
    }

    /**
     * 根据字典表主键id删除字典表信息
     * @param token
     * @param word_book_id
     * @return
     */
    @ApiOperation(value = "根据字典表主键id删除字典表信息",notes = "delWordBook接口的删除字典表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word_book_id", value = "字典表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @DeleteMapping("/delWordBook")
    public Result delWordBook(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              Integer word_book_id)
    {
        return wordBookLogic.delById(word_book_id);
    }

}
