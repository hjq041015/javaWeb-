package com.bookManagementSystem.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    String id;
    int book_id;
    String book_name;
    int student_id;
    String student_name;
    Date time;

}
