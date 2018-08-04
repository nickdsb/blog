package com.fufu.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserBean {
    String id,name,acount,password;
    Date joinTime,lastLoginTime;

    public UserBean(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
