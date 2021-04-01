package Test;

/**
 * @author i0bin
 * @Filename Java_Servlet_test.java
 * @date 2021/4/1
 **/

public class Java_Servlet_test {


    /*
    *
    *
    * 一.Servlet 特点
    *   1.就是一个Java类，继承了httpServlet
    *   2.一个普通的Java类实现了Servlet的继承，也叫做Servlet程序，基于http协议
    *   3.servlet程序交给服务器运行(tomcat)
    *
    * 二.Servlet开发流程
    *   1.编写一个Java类
    *   2.servlet交给服务器运行
    *       继承httpservlet,生成字节码文件,是放在WEB-INF
    *       jsp动态页面执行,web.xml中进行开启servlet
    *
    * 三.Servlet理解
    *   1.servlet就是可以和浏览器交互的Java文件
    *   2.主要用来接收页面的请求,并且做出对应的业务逻辑处理,给浏览器做出必要的回应
    *   3.也可以实现动态页面,比较麻烦,所有一般进行业务逻辑处理
    *
    * 四.Java类变成servlet的几种方式
    *   1.继承httpservlet(推荐)
    *   2.实现servlet接口
    *   3.继承GenericsServlet (不常用)
    *
    * 五.servlet的生命周期
    *   1.构造方法  在创建一个servlet对象调用的时候,并且只调用一次
    *           设计模式:单例模式  工厂模式
    *            servlet在服务器运行,单实例执行
    *   2.init方法 初始化方法 在创建完成后 进行调用
    *   3.service方法
    *
    *
    *
    *
    *
    * */
}
