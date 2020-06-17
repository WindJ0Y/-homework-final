package com.windj0y.jee.hw0.service;


import com.windj0y.jee.hw0.bean.proto.DBhomework;
import com.windj0y.jee.hw0.bean.proto.DBsubmit;
import com.windj0y.jee.hw0.bean.response.TeacherResponses.*;
import com.windj0y.jee.hw0.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherDao;

    public ListHomeworkResponse listhw(int uid) {
        List<ListHomeworkResponse.elm> list = teacherDao.getHomeworkList(uid);
        return new ListHomeworkResponse(0,"成功",list);
    }

    public InfoHomeworkResponse infohw(int uid, int hid) {
        DBhomework hw = teacherDao.getHomework(hid);
        List<InfoHomeworkResponse.elm> sb = teacherDao.getSubmits(hid);
        if(hw == null || hw.getTid() != uid){
            return new InfoHomeworkResponse(-11,"作业不存在",-1,"",
                    new ArrayList<>());
        }else{
            return new InfoHomeworkResponse(0,"成功",hid,hw.getTitle(),sb);
        }

    }

    public SubmitHomeworkResponse submithw(int uid,int sid,String content) {
        DBsubmit sb = teacherDao.getSubmitByID(sid);

        if(sb == null) {
            return new SubmitHomeworkResponse(-11, "提交不存在");
        }else if(sb.getStutext() == null || sb.getStutext() == ""){
            return new SubmitHomeworkResponse(-12, "学生没有提交");
        }
        DBhomework hw = teacherDao.getHomework(sb.getHid());
        if(hw == null || hw.getTid() != uid){
            return new SubmitHomeworkResponse(-13, "作业不存在");
        }
        teacherDao.doComit(sid,content);

        return new SubmitHomeworkResponse(0, "成功");

    }

    public AddHomeworkResponse add(int uid, String title, String content) {
        teacherDao.addHomework(uid,title,content);
        return new AddHomeworkResponse(0, "成功");
    }
}
