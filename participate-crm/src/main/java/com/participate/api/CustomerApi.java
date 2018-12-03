package com.participate.api;

import com.participate.entity.CustomerModel;
import com.participate.logic.CustomerLogic;
import com.participate.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 客户api层
 */
@io.swagger.annotations.Api(value="customer接口", tags="customer接口")
@RestController
@RequestMapping("api/customer")
public class CustomerApi extends BaseApi {
    @Autowired
    private CustomerLogic customerLogic;

    /**
     * 新增客户
     * @param token
     * @param customerModel
     * @return
     */
    @ApiOperation(value = "新增客户",notes = "addCustomer接口的添加客户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键）", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "customer_name", value = "姓名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "customer_phone_number", value = "手机号", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "customer_sex", value = "性别", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "customer_address", value = "家庭住址", required = false, dataType = "String", paramType = "form")

    })
    @ResponseBody
    @PostMapping("/addCustomer")
    public Result addCustomer(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      CustomerModel customerModel)
    {
        return customerLogic.add(customerModel);
    }

    /**
     * 删除客户（逻辑删除）
     * @param token
     * @param customer_id
     * @return
     */
    @ApiOperation(value = "删除客户",notes = "delCustomer接口的删除客户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/delCustomer")
    public Result delCustomer(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer customer_id)
    {
        return customerLogic.delCustomer(customer_id);
    }

    /**
     * 查询客户列表信息（可按条件模糊查询）
     * @param token
     * @param salesman_id
     * @param customer_name
     * @param customer_phone_number
     * @param customer_sex
     * @param customer_del
     * @param customer_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询客户列表信息（可按条件模糊查询）",notes = "selACustomer接口的查询客户列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "customer_name", value = "姓名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "customer_phone_number", value = "手机号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "customer_sex", value = "性别", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "customer_del", value = "删除状态（0是未删除，1是已删除）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "customer_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selACustomer")
    public Result selACustomer(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer salesman_id, String customer_name, String customer_phone_number,String customer_sex,Integer customer_del, String customer_create_time,Integer pageIndex,Integer pageSize)
    {
        return customerLogic.selAll(salesman_id, customer_name, customer_phone_number, customer_sex, customer_del, customer_create_time, pageIndex, pageSize);
    }

    /**
     * 修改客户信息
     * @param token
     * @param customerModel
     * @return
     */
   @ApiOperation(value = "修改客户信息",notes = "updCustomer接口的修改客户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/updCustomer")
    public Result updCustomer(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CustomerModel customerModel)
    {
        return customerLogic.updCustomer(customerModel);
    }

    /**
     * 根据id查询单条客户信息
     * @param token
     * @param customer_id
     * @return
     */
    @ApiOperation(value = "根据id查询单条客户信息",notes = "selOCustomer接口的查询单条客户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selOCustomer")
    public Result selOCustomer(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer customer_id)
    {
        return customerLogic.getById(customer_id);
    }

    /**
     * 根据销售id查看自己底下的客户信息功能
     * @param token
     * @param salesman_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "根据销售id查看自己底下的客户信息功能",notes = "salesmanGetByCustomer接口的根据销售id查看自己底下的客户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键）", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/salesmanGetByCustomer")
    public Result salesmanGetByCustomer(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer salesman_id,Integer pageIndex,Integer pageSize)
    {
        return customerLogic.salesmanGetByCustomer(salesman_id, pageIndex, pageSize);
    }

    /**
     * 销售与销售之间转让客户信息
     * @param token
     * @param customer_id
     * @param salesman_id
     * @return
     */
    @ApiOperation(value = "销售转让客户信息",notes = "salesmanGiveWay接口的销售之间转让客户信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键）", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/salesmanGiveWay")
    public Result salesmanGiveWay(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              Integer customer_id,Integer salesman_id)
    {
        return customerLogic.salesmanGiveWay(customer_id,salesman_id);
    }

}
