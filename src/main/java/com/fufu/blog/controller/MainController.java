package com.fufu.blog.controller;


import com.fufu.blog.entity.UserBean;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {


    @RequestMapping("")
    ModelAndView firstIndex(){
        return new ModelAndView("pages/index");
    }


    @RequestMapping("loginPage")
    ModelAndView login(){
        return new ModelAndView("pages/login");
    }

    @RequestMapping("registerPage")
    ModelAndView register(){
        return new ModelAndView("pages/register");
    }


    @RequestMapping("blog")
    ModelAndView blog(){
        return new ModelAndView("pages/blog");
    }
}
