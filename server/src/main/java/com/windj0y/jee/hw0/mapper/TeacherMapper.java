package com.windj0y.jee.hw0.mapper;

import com.windj0y.jee.hw0.bean.proto.DBhomework;
import com.windj0y.jee.hw0.bean.proto.DBsubmit;
import com.windj0y.jee.hw0.bean.response.TeacherResponses;
import com.windj0y.jee.hw0.bean.response.TeacherResponses.ListHomeworkResponse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TeacherMapper {

    @Select("select hid as id,title as name ,( " +
            " select count(*) from submit where submit.hid = id and submit.stutext != \"\" " +
            ") as submitcnt,( " +
            "  select count(*) from submit where submit.hid = id and submit.tchtext != \"\" " +
            ") as readcnt,( " +
            "  select count(*) from user_reg where role = 0 " +
            ") as total, " +
            "content from homework where tid = #{uid}")
    List<ListHomeworkResponse.elm> getHomeworkList(int uid);

    @Select("select * from homework where hid = #{hid}")
    DBhomework getHomework(int hid);

    @Select("select sid,nickname as name,stutext,tchtext " +
            "from submit as s " +
            "left join user_reg as u on s.uid = u.uid " +
            "where hid = #{hid}")
    List<TeacherResponses.InfoHomeworkResponse.elm> getSubmits(int hid);

    @Select("select * from submit where sid = #{sid}")
    DBsubmit getSubmitByID(int sid);

    @Update("update submit set tchtext = #{content} where sid = #{sid}")
    void doComit(int sid, String content);

    @Insert("insert into homework(tid,title,content) " +
            "values (#{uid},#{title},#{content})")
    void addHomework(int uid, String title, String content);
}
