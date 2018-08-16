package com.fufu.blog.mapper;

import com.fufu.blog.entity.UserBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SystemMapper {

    @Select("select view_count from mysystem")
    public Integer getCount();

    @Insert("insert into mysystem(view_count) values (#{view_count})")
    public void insert(Integer view_ount);

    @Delete("delete from mysystem where view_count=#{view_count}")
    public void delete(Integer view_count);

}
