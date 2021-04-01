package com.i0bin.xial.servlet;

import com.i0bin.xial.service.impl.PublishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author i0bin
 * @Filename PublishServlet.java
 * @date 2021/4/1
 **/

@WebServlet("/xialiao/publish")
public class PublishServlet extends HttpServlet {

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
        System.out.println(action);
        switch (action){
            case "publish":
                printWriter.write(new PublishServiceImpl().Upload(req));
                printWriter.flush();   //清除输出的缓存
                printWriter.close();  //关闭对应的IO资源
                break;
            case "queryall_publish":
                printWriter.write(new PublishServiceImpl().queryByPublish());
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
