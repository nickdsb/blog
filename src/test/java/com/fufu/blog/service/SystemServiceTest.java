package com.fufu.blog.service;

import com.fufu.blog.entity.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemServiceTest {
    @Autowired
    private SystemService service;

    @Test
    public void Test(){
        service.incCount();
    }
}
