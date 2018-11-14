package com.participate.controller;

import com.participate.entity.SysUserEntity;
import com.participate.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 胜多负少的
 */
@RestController
public class Usercontroller {

    @Autowired
    private SysUserService userService;

    @RequestMapping("/addUser")
    public String addUser(){
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setLoginname("fyg");
        userEntity.setLoginpass("789");
        userEntity.setArea("wer");
        userEntity.setCity("er");
        userEntity.setCompanyid(45l);
        userEntity.setCreatetime(new Date());
        userEntity.setLastloginaddr("3254");
        userEntity.setEmail("sdfsdf");
        userEntity.setLastloginip("798");
        userEntity.setLastlogintime(new Date());
        userEntity.setLogincount(1l);
        userEntity.setProvince("234");
        userEntity.setRemark("werwe");
        userEntity.setRoleid(1l);
        userEntity.setRemark("wer");
        userEntity.setRealname("465");
        int a = userService.addUser(userEntity);
        if (a!=0){
            return "添加成功";
        }else {
            return "798";
        }
    }

    @RequestMapping("/getUserList")
    public ModelAndView getUserList(Model model){
        List<SysUserEntity> userEntities =userService.getUserList();
        model.addAttribute("user",userEntities);
        return new ModelAndView( "/user/userlist","usermodel",model);
    }
    @RequestMapping("/gethtml")
    public ModelAndView gethtml(){
        return new ModelAndView("index");
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("sys/index");
    }

    @RequestMapping("/deleUser")
    public int deleUser(String id){
        long i=Long.parseLong(id);
        return userService.deleteUser(i);

    }

}
