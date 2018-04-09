package com.ishare.dao;

import java.sql.*;

/**
 * Created by lenovo on 2018/4/6.
 */
public class ConnectionManager {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/demo";
    private static final String DBNAME = "root";
    private static final String DBPASS = "123456";

    private static Connection connection;

    public static Connection getConnection(){

        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,DBNAME,DBPASS);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
