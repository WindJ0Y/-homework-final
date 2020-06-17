package com.windj0y.jee.hw0.service;


import com.windj0y.jee.common.StringUtil;
import com.windj0y.jee.hw0.bean.proto.DBhomework;
import com.windj0y.jee.hw0.bean.proto.DBsubmit;
import com.windj0y.jee.hw0.bean.proto.DBuser_reg;
import com.windj0y.jee.hw0.bean.response.StudentResponses.*;
import com.windj0y.jee.hw0.bean.request.StudentRequests.*;
import com.windj0y.jee.hw0.mapper.StudentMapper;
import com.windj0y.jee.hw0.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentMapper studentDao;

    public ListHomeworkResponse listhw(int uid) {
        List<ListHomeworkResponse.elm> rtn = studentDao.getHomeworkList(uid);
        return new ListHomeworkResponse(0,"成功",rtn);
    }

    public InfoHomeworkResponse infohw(int uid, int hid) {
        DBhomework hw = studentDao.getHomework(hid);
        DBsubmit sb = studentDao.getSubmit(uid, hid);
        if(hw == null){
            return new InfoHomeworkResponse(-11,"作业不存在",-1,"",
                    false,false,"","");
        }
        if(sb == null){
            return new InfoHomeworkResponse(0,"成功",hid,hw.getTitle(),
                    false,false,"","");
        }else{
            return new InfoHomeworkResponse(0,"成功",hid,hw.getTitle(),
                    true,!sb.getTchtext().isEmpty(),sb.getStutext(),sb.getTchtext());
        }
    }

    public SubmitHomeworkResponse submithw(int uid,int hid,String content) {
        DBhomework hw = studentDao.getHomework(hid);
        DBsubmit sb = studentDao.getSubmit(uid, hid);
        if(hw == null){
            return new SubmitHomeworkResponse(-11,"作业不存在");
        }
        if(sb != null && !sb.getTchtext().isEmpty()){
            return new SubmitHomeworkResponse(-12,"已经批阅的作业不可修改");
        }else{
            if(sb == null){
                studentDao.doSubmit(uid, hid, content);
            }else{
                studentDao.doUpdateSubmit(sb.getSid(), content);
            }
            return new SubmitHomeworkResponse(0,"成功");
        }
    }

}
