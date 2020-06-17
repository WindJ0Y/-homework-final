package com.windj0y.jee.hw0.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.windj0y.jee.hw0.bean.proto.*;

@Mapper
@Component
public interface UserMapper {

    @Select("select * from user_reg " +
            "where nickname = #{username} and password = #{password} and role = #{role}")
    DBuser_reg getRegByAll(String username,String password,int role);

    @Select("select * from user_reg " +
            "where uid = #{uid} ")
    DBuser_reg getRegByID(int uid);

    @Insert("insert into user_login " +
            "values (#{uid},#{token}) " +
            "ON DUPLICATE KEY UPDATE token = #{token}")
    void updateToken(int uid,String token);

    @Select("select count(*) from user_login " +
            "where uid = #{uid} and token = #{token}")
    int checkUser(int uid,String token);

    @Select("select role from user_reg " +
            "where uid = #{uid}")
    int getRole(int uid);

    @Select("select count(*) from user_reg " +
            "where nickname = #{username}")
    int getUserByUsername(String username);

    @Insert("insert into user_reg(nickname,password,role) " +
            "values (#{username},#{password},#{role})")
    void doReg(String username, String password, int role);
}
