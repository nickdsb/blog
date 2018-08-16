package com.fufu.blog.service;

import com.fufu.blog.entity.UserBean;
import com.fufu.blog.mapper.SystemMapper;
import com.fufu.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    @Autowired
    SystemMapper mapper;

    public void incCount(){
        int temp=mapper.getCount();
        mapper.delete(temp);
        mapper.insert(temp+1);
    }

    public Integer getCount(){
        return mapper.getCount();
    }
}
