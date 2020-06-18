package com.windj0y.jee.hw0.controller;

import com.windj0y.jee.hw0.bean.request.TeacherRequests.*;
import com.windj0y.jee.hw0.bean.response.TeacherResponses.*;

import com.windj0y.jee.hw0.service.TeacherService;
import com.windj0y.jee.hw0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/listhw")
    public ListHomeworkResponse listhw(@Valid ListHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new ListHomeworkResponse(-10,"参数错误", new ArrayList<>());
        }
        if(userService.getRole(req.getUid(),req.getToken()) != 1){
            return new ListHomeworkResponse(-1,"身份验证错误", new ArrayList<>());
        }
        return teacherService.listhw(req.getUid());
    }

    @RequestMapping("/infohw")
    public InfoHomeworkResponse infohw(@Valid InfoHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new InfoHomeworkResponse(-10,"参数错误",-1,"",
                    new ArrayList<>());
        }
        if(userService.getRole(req.getUid(),req.getToken()) != 1){
            return new InfoHomeworkResponse(-1,"身份验证错误",-1,"",
                    new ArrayList<>());
        }
        return teacherService.infohw(req.getUid(), req.getHid());
    }

    @RequestMapping("/submithw")
    public SubmitHomeworkResponse submithw(@Valid SubmitHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new SubmitHomeworkResponse(-10,"参数错误");
        }
        if(userService.getRole(req.getUid(),req.getToken()) != 1){
            return new SubmitHomeworkResponse(-1,"身份验证错误");
        }
        return teacherService.submithw(req.getUid(), req.getSid(), req.getContent());
    }

    @RequestMapping("/add")
    public AddHomeworkResponse submithw(@Valid AddHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new AddHomeworkResponse(-10,"参数错误");
        }
        return teacherService.add(req.getUid(), req.getTitle(), req.getContent());
    }

}
