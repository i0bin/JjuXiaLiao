package com.i0bin.xial.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @DBHelper 数据的连接、关闭、编译sql语句等操作
 *
 * **/

public class DBHelper {

    public static final String URL = "jdbc:mysql://localhost:3306/xialiao1?useUnicode=true&&characterEncoding=utf8&&useSSL=true";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASSWORD = "hello1";
    public static Connection conn = null;
    public static PreparedStatement pst = null;

    // 加载驱动、连接成功的方法
    public DBHelper(String sql){
        try {
            // 1. 加载驱动
            Class.forName(CLASSNAME);
            System.out.println("加载成功");
            // 2.连接数据库
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("连接成功");
            // 3.编译SQL语句
            pst = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 关闭连接
    public void close(){
        if (this.conn!=null){
            try {
                this.pst.close();
                this.conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
