package com.windj0y.jee.hw0.controller;

import com.windj0y.jee.hw0.bean.request.UserRequests.*;
import com.windj0y.jee.hw0.bean.response.UserResponses.*;
import com.windj0y.jee.hw0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public LoginResponse login(@Valid LoginRequest req, BindingResult br) {
        if(br.hasErrors()){
            return new LoginResponse(-10,"参数错误",-1,"");
        }
        return userService.login(req.getUsername(),req.getPassword(),req.getRole());
    }

}
