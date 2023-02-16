package com.gl.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamemange","root", "password");
            System.out.println("SuccessFully Connected to DataBase!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to Connect DataBase");
            e.printStackTrace();
        }
        return connection;
    }
}
