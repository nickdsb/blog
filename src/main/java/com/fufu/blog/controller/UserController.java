package com.fufu.blog.controller;


import com.fufu.blog.entity.UserBean;
import com.fufu.blog.service.UserService;
import com.fufu.blog.util.ModelAndViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("addUser")
    ModelAndView addUser(String id,String name,String password,String verificationCode,ModelMap map){
        if(verificationCode.equals("gg")){
            UserBean user=new UserBean("gg","name","password");
            service.addUser(user);
            map=ModelAndViewUtil.getMessageMap(map,"success","msg","注册成功.......","/");
            return new ModelAndView("common/message");
        }else{
            map=ModelAndViewUtil.getMessageMap(map,"error","msg","验证码错误.......","/");
            return new ModelAndView("common/message");
        }
    }

    @RequestMapping("login")
    ModelAndView addUser(String id,String password,String verificationCode,ModelMap map){
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
