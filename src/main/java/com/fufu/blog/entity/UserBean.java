package com.fufu.blog.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserBean {

    @NotNull
    private String id;

    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    private String name;

    private String acount;
    private Date joinTime;
    private Date lastLoginTime;
    int level;

    public UserBean(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level=level;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", acount='" + acount + '\'' +
                ", password='" + password + '\'' +
                ", joinTime=" + joinTime +
                ", lastLoginTime=" + lastLoginTime +
                ", level=" + level +
                '}';
    }
}
