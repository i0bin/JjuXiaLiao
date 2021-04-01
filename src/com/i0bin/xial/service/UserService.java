package com.i0bin.xial.service;

import com.i0bin.xial.bean.User;

public interface UserService {

//    1.登陆业务
    public String login(User user);

//    2.注册业务
    public String register(User user);

//    3.修改密码业务
    public String UpdatePwd(User user);

//    4.个人信息业务
    public int queryById(Integer id);




}
