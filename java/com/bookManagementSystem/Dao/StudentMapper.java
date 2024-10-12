package com.bookManagementSystem.Dao;

import com.bookManagementSystem.Entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> getStudentList();
}
