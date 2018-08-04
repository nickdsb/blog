package com.fufu.blog.mapper;

import com.fufu.blog.entity.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public UserBean selectUserById(String id);

    @Select("select * from user where name = #{name}")
    public List<UserBean> selectUserByName(String name);

    @Insert("insert into user(id,name,password) values (#{id},#{name},#{password})")
    public void addUser(UserBean user);

    /*@Update("update user set userName=#{userName},userAge=#{userAge},userAddress=#{userAddress} where id=#{id}")
    public void updateUser(UserBean user);*/

    @Delete("delete from user where id=#{id}")
    public void deleteUser(String id);
}
