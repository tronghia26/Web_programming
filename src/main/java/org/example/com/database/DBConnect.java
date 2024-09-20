package org.example.com.database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DBConnect {
    static String URL = "jdbc:mysql://localhost:3306/ltweb";
    static String USER = "root";
    static String PASSWORD = "root";
    static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            System.out.println("Connected to the database");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Failed to connect to the database");
            return null;
        }
    }
}