package com.fufu.blog.service;

import com.fufu.blog.entity.UserBean;
import com.fufu.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    public void addUser(UserBean user){
        mapper.addUser(user);
    }
}
