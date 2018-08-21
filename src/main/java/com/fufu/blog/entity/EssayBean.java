package com.fufu.blog.entity;


import lombok.Data;

import java.util.Date;

@Data
public class EssayBean {
    private String author,title,content;
    Date dateTime;

    public EssayBean(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "EssayBean{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
