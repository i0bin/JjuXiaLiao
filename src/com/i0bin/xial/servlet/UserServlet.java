package com.i0bin.xial.servlet;

import com.i0bin.xial.bean.User;
import com.i0bin.xial.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author i0bin
 * @Filename UserServlet.java
 * @date 2021/4/1
 **/

@WebServlet("/xialiao/user")
public class UserServlet extends HttpServlet {

//    请求方式 get post

//


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码过滤
        req.setCharacterEncoding("utf-8");

//        响应的编码进行过滤
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        实例化一个输出对象
        PrintWriter printWriter = resp.getWriter();
//        请求的数据进行解析
        String action = req.getParameter("action");
//        登陆和注册
        switch (action){
            case "login":
                User userL = new User();
                userL.setUsername(req.getParameter("username"));
                userL.setPassword(req.getParameter("password"));

//                验证输出的业务
                printWriter.write(new UserServiceImpl().login(userL));
                printWriter.flush();   //清除输出的缓存
                printWriter.close();  //关闭对应的IO资源
                break;
            case "register":
                User userR = new User();
                userR.setNickname(req.getParameter("nickname"));
                userR.setUsername(req.getParameter("username"));
                userR.setPassword(req.getParameter("password"));

//                验证输出的业务
                printWriter.write(new UserServiceImpl().register(userR));
                printWriter.flush();   //清除输出的缓存
                printWriter.close();  //关闭对应的IO资源
                break;

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
