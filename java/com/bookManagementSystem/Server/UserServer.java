package com.bookManagementSystem.Server;

import jakarta.servlet.http.HttpSession;

public interface UserServer {
    boolean isExit(String username , String password , HttpSession session);
}
