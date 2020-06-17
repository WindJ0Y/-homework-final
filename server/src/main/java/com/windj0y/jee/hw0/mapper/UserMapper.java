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

    @Insert("insert into user_login " +
            "values (#{uid},#{token}) " +
            "ON DUPLICATE KEY UPDATE token = #{token}")
    void updateToken(int uid,String token);

}
