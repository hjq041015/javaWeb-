package com.bookManagementSystem.Server.impl;

import com.bookManagementSystem.Dao.StudentMapper;
import com.bookManagementSystem.Entity.Student;
import com.bookManagementSystem.Server.StudentServer;
import com.bookManagementSystem.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServerImpl implements StudentServer {
    @Override
    public List<Student> getStudentList() {
        try (SqlSession session = MybatisUtil.openSession(true)){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.getStudentList();
        }
    }
}
