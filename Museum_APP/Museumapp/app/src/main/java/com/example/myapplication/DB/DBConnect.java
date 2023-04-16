package com.example.myapplication.DB;

import java.sql.*;

public class DBConnect {
    public static String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://rm-2ze26m1rmgm0i3v8pjo.mysql.rds.aliyuncs.com:3306/museum?useUnicode=true&characterEncoding=UTF-8";
    //public static String url = "jdbc:mysql://192.168.31.22:3306/museum?useUnicode=true&characterEncoding=UTF-8";
    public static String user = "museum";
    //public static String password = "A2+B2=C2";
    public static String password = "A2+B2=C2";

    public static Connection GetConnection()  {
        Connection conn = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = (Connection)DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
