package com.fufu.blog.util;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewUtil {

    public static ModelMap getMessageMap(ModelMap map,String type,String msg,String message,String nextPagePath){
        map.put("type",type);
        map.put("msg",msg);
        map.put("message",message+".......");
        map.put("nextPagePath",nextPagePath);
        return map;
    }
}
