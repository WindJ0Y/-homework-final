package com.windj0y.jee.hw0.controller;

import com.windj0y.jee.hw0.bean.request.StudentRequests.*;
import com.windj0y.jee.hw0.bean.response.StudentResponses.*;

import com.windj0y.jee.hw0.service.StudentService;
import com.windj0y.jee.hw0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/listhw")
    public ListHomeworkResponse listhw(@Valid ListHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new ListHomeworkResponse(-10,"参数错误", new ArrayList<>());
        }
        if(userService.getRole(req.getUid(),req.getToken()) != 0){
            return new ListHomeworkResponse(-1,"身份验证错误", new ArrayList<>());
        }
        return studentService.listhw(req.getUid());
    }

    @RequestMapping("/infohw")
    public InfoHomeworkResponse infohw(@Valid InfoHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new InfoHomeworkResponse(-10,"参数错误",-1,"",
                    false,false,"","");
        }
        if(userService.getRole(req.getUid(),req.getToken()) != 0){
            return new InfoHomeworkResponse(-1,"身份验证错误",-1,"",
                    false,false,"","");
        }
        return studentService.infohw(req.getUid(), req.getHid());
    }

    @RequestMapping("/submithw")
    public SubmitHomeworkResponse submithw(@Valid SubmitHomeworkRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new SubmitHomeworkResponse(-10,"参数错误");
        }
        if(userService.getRole(req.getUid(),req.getToken()) != 0){
            return new SubmitHomeworkResponse(-1,"身份验证错误");
        }
        return studentService.submithw(req.getUid(), req.getHid(), req.getContent());
    }

}
