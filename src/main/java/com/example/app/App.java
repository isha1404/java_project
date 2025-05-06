package com.example.app;

import com.example.service.UserService;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/sampledb";
            String username = "user";
            String password = "password";
            Connection conn = DriverManager.getConnection(url, username, password);
            UserService userService = new UserService(conn);
            userService.createUser("Bob", "bob@example.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
