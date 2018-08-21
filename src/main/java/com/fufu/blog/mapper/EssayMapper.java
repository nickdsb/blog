package com.fufu.blog.mapper;

import com.fufu.blog.entity.EssayBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EssayMapper {

    @Select("select * from essay where id = #{id}")
    EssayBean getOne(Integer id);

    @Select("select * from essay where author = #{author}")
    List<EssayBean> getByUser(String author);

    @Insert("insert into essay(author,title,content) values (#{author},#{title},#{content})")
    void insert(EssayBean essay);

    /*@Update("update user set userName=#{userName},userAge=#{userAge},userAddress=#{userAddress} where id=#{id}")
    public void updateUser(UserBean user);*/

    @Delete("delete from essay where id=#{id}")
    void delete(Integer id);

    @Delete("delete from essay where author=#{author}")
    void deleteByEssay(EssayBean essay);
}
