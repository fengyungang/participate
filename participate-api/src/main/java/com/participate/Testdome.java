package com.participate;

import com.participate.entity.SysUserEntity;
import com.participate.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Testdome {

    @Autowired
    private UserMapper userMapper;

    public void main(String[] args) {
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
        int a =userMapper.insertUser(userEntity);
    }
}
