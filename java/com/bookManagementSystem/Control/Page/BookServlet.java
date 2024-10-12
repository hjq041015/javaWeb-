package com.bookManagementSystem.Control.Page;

import com.bookManagementSystem.Entity.User;
import com.bookManagementSystem.Server.BookServer;
import com.bookManagementSystem.Server.impl.BookServerImpl;
import com.bookManagementSystem.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    BookServer server;
    @Override
    public void init() throws ServletException {
        server = new BookServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Context context = new Context();
        User user =(User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("book_list",server.getBookList().keySet());
        context.setVariable("book_list_status",new ArrayList<>(server.getBookList().values()));
        ThymeleafUtil.process("books.html",context,resp.getWriter());
    }
}
