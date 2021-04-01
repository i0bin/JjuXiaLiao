package com.i0bin.xial.dao;


import com.i0bin.xial.bean.User;

public interface UserDao {

//    1.数据查询

    public User queryUser(User user);
//    2.数据添加

    public void insertUser(User user);
//    3.数据的修改

    public void DataUpdate(User user);
    //    4.根据ID查询
    public int queryUserId(Integer id);


}
