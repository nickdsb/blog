package com.fufu.blog.controller;


import com.fufu.blog.entity.UserBean;
import com.fufu.blog.service.UserService;
import com.fufu.blog.util.ModelAndViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService service;

    //register页面
    @GetMapping("register")
    public ModelAndView register(){
        return new ModelAndView("pages/register");
    }
    //register后台处理
    @PostMapping("register")
    public ModelAndView addUser(@Valid UserBean user, Errors errors, String verificationCode, ModelMap map){
        if(errors.hasErrors()){
            System.out.println("valid");
            map=ModelAndViewUtil.getMessageMap(map,"error","msg","输入有错误.......","/");
            return new ModelAndView("common/message");
        }

        if(verificationCode.equals("gg")){
            service.addUser(user);
            map=ModelAndViewUtil.getMessageMap(map,"success","msg","注册成功.......","/");
            return new ModelAndView("common/message");
        }else{
            map=ModelAndViewUtil.getMessageMap(map,"error","msg","验证码错误.......","/");
            return new ModelAndView("common/message");
        }
    }

    //login页面处理
    @GetMapping("login")
    public ModelAndView login(){
        return new ModelAndView("pages/login");
    }
    //login后台处理
    @PostMapping("login")
   public  ModelAndView addUser(String id,String password,String verificationCode,ModelMap map){
        if(verificationCode.equals("gg")){
            if(service.loginJudge(id,password)){
                map=ModelAndViewUtil.getMessageMap(map,"success","msg","登录成功.......","/");
                return new ModelAndView("common/message");
            }else{
                map=ModelAndViewUtil.getMessageMap(map,"error","msg","帐号密码错误.......","/");
                return new ModelAndView("common/message");
            }
        }else{
            map=ModelAndViewUtil.getMessageMap(map,"error","msg","验证码错误.......","/");
            return new ModelAndView("common/message");
        }

    }

}
