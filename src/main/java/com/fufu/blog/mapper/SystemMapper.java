package com.fufu.blog.mapper;

import com.fufu.blog.entity.UserBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SystemMapper {

    @Select("select view_count from mySystem")
    public Integer getCount();

    @Insert("insert into mySystem(view_count) values (#{view_count})")
    public void insert(Integer view_ount);

    @Delete("delete from mySystem where view_count=#{view_count}")
    public void delete(Integer view_count);

}
