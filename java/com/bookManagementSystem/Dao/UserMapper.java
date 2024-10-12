package com.bookManagementSystem.Dao;

import com.bookManagementSystem.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from admin where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username ,@Param("password") String password);



}
