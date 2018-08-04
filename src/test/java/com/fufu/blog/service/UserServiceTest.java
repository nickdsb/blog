package com.fufu.blog.service;

import com.fufu.blog.BlogApplication;
import com.fufu.blog.entity.UserBean;
import com.fufu.blog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void Test(){

        UserBean user=new UserBean("gdddddgg","name","password");
        service.addUser(user);

    }
}
