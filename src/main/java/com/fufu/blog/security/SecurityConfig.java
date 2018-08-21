package com.fufu.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    private List<String> filterUrls;


    @PostConstruct
    public void initUrls(){
        filterUrls=new ArrayList<>();
        filterUrls.add("/blog");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers((String[])filterUrls.toArray(new String[filterUrls.size()])).authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and()
                .rememberMe().tokenValiditySeconds(50).key("userKey")
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select id ,password,1 from user where id=?")
                .authoritiesByUsernameQuery("select id,'ROLE_USER' from user where id=?")
                .passwordEncoder(new BlankPasswordEncoder());
    }
}
