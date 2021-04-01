package com.i0bin.xial.dao.impl;

import com.i0bin.xial.bean.User;
import com.i0bin.xial.dao.UserDao;
import com.i0bin.xial.util.DBHelper;
import com.i0bin.xial.util.Result;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author i0bin
 * @Filename UserDaoImpl.java
 * @date 2021/4/1
 **/

public class UserDaoImpl implements UserDao {


    @Override
    public User queryUser(User user) {

//        查询用户

        DBHelper db = new DBHelper("select * from users where username = '"+user.getUsername()+"'");
        try {
            ResultSet resultSet = db.pst.executeQuery();
            user = new User();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setIcon(resultSet.getString("icon"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.close();
        }

        return user;
    }

    @Override
    public void insertUser(User user) {

//        插入数据的语句
        DBHelper db = new DBHelper("insert into users(nickname,username,password) value(?,?,?);");
        try {
            db.pst.setString(1,user.getNickname());
            db.pst.setString(2,user.getUsername());
            db.pst.setString(3,user.getPassword());
            db.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close();
        }



    }

    @Override
    public void DataUpdate(User user) {

    }

    @Override
    public int queryUserId(Integer id) {
        return 0;
    }
}
