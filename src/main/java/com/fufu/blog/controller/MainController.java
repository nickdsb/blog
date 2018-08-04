package com.fufu.blog.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {


    @RequestMapping("")
    ModelAndView firstIndex(){
        return new ModelAndView("pages/index");
    }


    @RequestMapping("login")
    ModelAndView login(){
        return new ModelAndView("pages/login");
    }

    @RequestMapping("register")
    ModelAndView register(){
        return new ModelAndView("pages/register");
    }
}
