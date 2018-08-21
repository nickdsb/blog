package com.fufu.blog.mapper;


import com.fufu.blog.BlogApplication;
import com.fufu.blog.entity.EssayBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EssayMapperTest {

    @Autowired
    EssayMapper mapper;

    @Test
    public void test(){
        EssayBean essay=new EssayBean("fufu","title","xxxxxxxxxxxxxxx");
        mapper.insert(essay);
        System.out.println(mapper.getOne(0));
    }


}
