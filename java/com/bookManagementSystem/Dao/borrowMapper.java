package com.bookManagementSystem.Dao;

import com.bookManagementSystem.Entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface borrowMapper {
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "bid",property = "book_id"),
            @Result(column = "title",property = "book_name"),
            @Result(column = "sid",property = "student_id"),
            @Result(column = "name",property = "student_name"),
            @Result(column = "time",property = "time"),
    })
    @Select("SELECT *FROM borrow,student ,book WHERE borrow.bid = book.bid AND student.sid = borrow.sid")
    List<Borrow> getBorrowList();

     @Delete("delete  from borrow where id = #{id}")
     void deleteBorrow(String id);

     @Insert("insert into borrow(sid,bid,time) values (#{sid}, #{bid}, NOW())")
     void addBorrow(@Param("sid") int sid,@Param("bid") int bid);
}
