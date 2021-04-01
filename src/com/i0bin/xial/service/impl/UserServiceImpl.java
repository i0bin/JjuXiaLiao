package com.i0bin.xial.service.impl;

import com.google.gson.Gson;
import com.i0bin.xial.bean.User;
import com.i0bin.xial.dao.impl.UserDaoImpl;
import com.i0bin.xial.service.UserService;
import com.i0bin.xial.util.Result;

/**
 * @author i0bin
 * @Filename UserServiceImpl.java
 * @date 2021/4/1
 **/

public class UserServiceImpl implements UserService {
    @Override
    public String login(User user) {

        Result result = new Result();
        User user_dao = new UserDaoImpl().queryUser(user);

//        将数据访问拿到的数据集进行判断

        if (user_dao.getUsername() != null){
            if (user.getPassword().equals(user_dao.getPassword())){
//                当判断两次的密码相同,代表登陆验证成功,
//                传递成功的信息

                result.setStatus("success");
                result.setMessage("登陆成功");
//                成功之后将数据传递给前端界面
                result.setTotal(new Gson().toJson(user_dao));
            }else {
                result.setStatus("error");
                result.setMessage("密码错误");
            }
        }else {
            result.setStatus("error");
            result.setMessage("用户名不存在");
        }

        return new Gson().toJson(result);

    }

    @Override
    public String register(User user) {
        Result result = new Result();
//        要想注册  必须先查询
        User user_dao = new UserDaoImpl().queryUser(user);
//        判断是否存在同名的用户
        if (user_dao.getUsername()==null){
            new UserDaoImpl().insertUser(user);
            result.setStatus("success");
            result.setMessage("注册成功");

        }else {
            result.setStatus("error");
            result.setMessage("用户已存在");
        }

        return new Gson().toJson(result);



    }

    @Override
    public String UpdatePwd(User user) {
        return null;
    }

    @Override
    public int queryById(Integer id) {
        return 0;
    }
}
