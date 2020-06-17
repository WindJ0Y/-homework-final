package com.windj0y.jee.hw0.service;


import com.windj0y.jee.common.StringUtil;
import com.windj0y.jee.hw0.bean.response.UserResponses.*;
import com.windj0y.jee.hw0.mapper.UserMapper;
import com.windj0y.jee.hw0.bean.proto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public LoginResponse login(String username, String password, int role){
        DBuser_reg info = userDao.getRegByAll(username,password,role);
        if(info == null){
            return new LoginResponse(-1,"用户名或密码错误",-1,"");
        }
        String token = StringUtil.getRandString(32);
        userDao.updateToken(info.getUid(),token);
        return new LoginResponse(0,"登陆成功",info.getUid(),token);
    }

}
