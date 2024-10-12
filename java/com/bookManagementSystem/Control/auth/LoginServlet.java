package com.bookManagementSystem.Control.auth;

import com.bookManagementSystem.Server.UserServer;
import com.bookManagementSystem.Server.impl.UserServerImpl;
import com.bookManagementSystem.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserServer server;
    @Override
    public void init() throws ServletException {
        server = new UserServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        if (req.getSession().getAttribute("failure") != null ) {
           context.setVariable("failure",true);
           req.getSession().removeAttribute("failure");
        }
        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("/index");
            return;
        }
        ThymeleafUtil.process("login.html",context,resp.getWriter());
        resp.setContentType("text/Html;charset=utf-8");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        if (server.isExit(username,password, req.getSession())){
           resp.sendRedirect("/index");
        }else {
            req.getSession().setAttribute("failure",new Object());
            this.doGet(req,resp);
        }
    }
}
