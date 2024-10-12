package com.bookManagementSystem.Control.Page;

import com.bookManagementSystem.Entity.User;
import com.bookManagementSystem.Server.StudentServer;
import com.bookManagementSystem.Server.impl.StudentServerImpl;
import com.bookManagementSystem.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    StudentServer server;
    @Override
    public void init() throws ServletException {
        server = new StudentServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Context context = new Context();
        User user =(User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("student_list",server.getStudentList());
        ThymeleafUtil.process("students.html",context,resp.getWriter());
    }
}
