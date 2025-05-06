package com.example.service;

import com.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserService {
    private Connection conn;

    public UserService(Connection conn) {
        this.conn = conn;
    }

    public void createUser(String name, String email) {
        try {
            User user = new User(name, email);
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            System.out.println("User created: " + user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
