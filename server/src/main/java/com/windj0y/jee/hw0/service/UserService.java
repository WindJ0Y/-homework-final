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

    public boolean checkUser(int uid, String token) {
        if(token.isEmpty())return false;
        return userDao.checkUser(uid, token) == 1;
    }

    public int getRole(int uid, String token) {
        if(! checkUser(uid, token)) return -1;
        return userDao.getRole(uid);
    }

    public LoginResponse login(String username, String password, int role){
        DBuser_reg info = userDao.getRegByAll(username,password,role);
        if(info == null){
            return new LoginResponse(-1,"用户名或密码错误",-1,"");
        }
        String token = StringUtil.getRandString(32);
        userDao.updateToken(info.getUid(),token);
        return new LoginResponse(0,"登陆成功",info.getUid(),token);
    }

    public LogoutResponse logout(int uid){
        userDao.updateToken(uid,"");
        return new LogoutResponse(0,"登出成功");
    }

    public InfoResponse info(int uid){
        DBuser_reg info = userDao.getRegByID(uid);
        return new InfoResponse(0,"成功",info.getRole(),info.getNickname());
    }

    public RegResponse register(String username, String password, int role) {
        int cnt = userDao.getUserByUsername(username);
        if(cnt != 0){
            return new RegResponse(-1,"有重名");
        }
        userDao.doReg(username,password,role);
        return new RegResponse(0,"成功");
    }
}
