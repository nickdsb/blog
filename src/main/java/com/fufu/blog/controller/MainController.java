package com.fufu.blog.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {


    @RequestMapping("")
    public ModelAndView firstIndex(){
        return new ModelAndView("pages/index");
    }







    @RequestMapping("blog")
    public ModelAndView blog(){
        return new ModelAndView("pages/blog");
    }
}
