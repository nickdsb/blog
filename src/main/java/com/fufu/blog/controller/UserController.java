package com.fufu.blog.controller;


import com.fufu.blog.entity.UserBean;
import com.fufu.blog.service.UserService;
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

            map.put("type","success");
            map.put("msg","msg");
            map.put("message","message.......");
            map.put("nextPagePath","/");
            return new ModelAndView("common/message");
        }else{
            map.put("type","error");
            map.put("msg","msg");
            map.put("message","message.......");
            map.put("nextPagePath","/");
            return new ModelAndView("common/message");
        }

    }
}
