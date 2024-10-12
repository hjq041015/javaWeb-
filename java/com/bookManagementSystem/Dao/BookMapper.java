package com.bookManagementSystem.Dao;

import com.bookManagementSystem.Entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from book where bid =  #{bid}")
    void deleteBook(int bid);

    @Insert("insert into book(title ,`desc`,price) values (#{title}, #{desc}, #{price})")
    void addBook(@Param("title") String title ,@Param("desc") String desc,@Param("price") double price);
}
