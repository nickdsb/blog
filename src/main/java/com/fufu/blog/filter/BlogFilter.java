package com.fufu.blog.filter;

import com.fufu.blog.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
public class BlogFilter implements Filter {
    @Autowired
    protected SystemService service;
    private static BlogFilter  blogFilter ;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        blogFilter = this;
        blogFilter.service = this.service;
        // 初使化时将已静态化的testService实例化
    }
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if(session.getAttribute("view_count")==null){
            blogFilter.service.incCount();
            session.setAttribute("view_count",blogFilter.service.getCount());
            System.out.println("view++");
        }
        System.out.println("filter working");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}