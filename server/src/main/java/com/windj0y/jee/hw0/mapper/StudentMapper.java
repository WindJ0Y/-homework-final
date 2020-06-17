package com.windj0y.jee.hw0.mapper;

import com.windj0y.jee.hw0.bean.proto.DBhomework;
import com.windj0y.jee.hw0.bean.proto.DBsubmit;
import com.windj0y.jee.hw0.bean.proto.DBuser_reg;
import com.windj0y.jee.hw0.bean.response.StudentResponses.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    @Select("select h.hid as id," +
            "h.title as name, " +
            "!isnull(sid) as submited, " +
            "(!isnull(tchtext) and !(tchtext = \"\" )) as bbed, " +
            "h.content " +
            "from homework as h LEFT JOIN submit as s " +
            "on h.hid = s.hid " +
            "WHERE (isnull(s.uid) or s.uid = #{uid} )")
    List<ListHomeworkResponse.elm> getHomeworkList(int uid);

    @Select("select * from homework where hid = #{hid}")
    DBhomework getHomework(int hid);

    @Select("select * from submit where uid = #{uid} and hid = #{hid}")
    DBsubmit getSubmit(int uid, int hid);

    @Insert("insert into submit(hid,uid,stutext,tchtext) " +
            "values (#{hid},#{uid},#{content},\"\")")
    void doSubmit(int uid, int hid, String content);

    @Update("update submit set stutext = #{content} where sid = #{sid}")
    void doUpdateSubmit(int sid, String content);

}
