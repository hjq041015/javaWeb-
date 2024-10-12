package com.bookManagementSystem.Entity;

import lombok.Data;

@Data
public class User {
    int id;
    String username;
    String nickname;
    String password;
}
