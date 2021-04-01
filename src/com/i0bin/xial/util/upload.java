package com.i0bin.xial.util;

import com.i0bin.xial.bean.Publish;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Bug小能手
 * @NAME:mi
 * @Date: 2020/12/22 10:32
 * @Description:
 */

//文件上传,
public class upload {

    public Publish upload_file(String path, HttpServletRequest req){

        Publish publish = new Publish();


        // 1.判断是否是多文件提交对象
        if (!ServletFileUpload.isMultipartContent(req)){
            System.out.println("无文件");
            return null;
        }

        // 2.创建保存的文件目录
        File file = new File(path);
        // 3.验证目录是否存在
        if (!file.exists()&&!file.isDirectory()){
            file.mkdir(); // 4.创建
        }

        // 5.初始化配置
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        servletFileUpload.setHeaderEncoding("utf-8");

        // 6.解析请求对象：分解出提交的文本和File文件
        try {
            // parseRequest:解析
            // ServletRequestContext:转换对象类型
            List<FileItem> list = servletFileUpload.parseRequest(new ServletRequestContext(req));
            // 7.循环遍历列表，获取文本和文件
            for (FileItem item:list) {
                // 8.判断文本类型 isFormField
                if (item.isFormField()){
                    String name = item.getFieldName(); // 获取input的name属性
                    String value = item.getString("utf-8"); // 获取input的value属性

                    if (name.equals("publish-content-txt")){
                        System.out.println("内容："+value);
                        publish.setContent_txt(value);
                    }

                    if (name.equals("date")){
                        System.out.println("时间："+value);
                        publish.setDate(value);
                    }

                    if (name.equals("sign")){
                        System.out.println("标示："+value);
                        publish.setSign(value);
                    }

                    if (name.equals("nickname")){
                        System.out.println("昵称："+value);
                        publish.setNickname(value);
                    }

                }else {//文件格式
                    // 9.获取文件名称 replace：剔除空格字符
                    String fileName = item.getName().replace(" ","");
                    // 10.如果为null，继续循环
                    if (fileName==null||fileName.equals("")){continue;}
                    publish.setContent_img(fileName);

                    // 11.通过IO流上传文件到 ../icon/img
                    InputStream is = item.getInputStream();
                    // 12.创建输出流
                    FileOutputStream os = new FileOutputStream(path+"/"+fileName);
                    // 13.创建缓存字节数组 长度1024
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    // 14.循环读取和写入
                    while ((len = is.read(buffer))>0){
                        os.write(buffer,0,len);
                    }
                    os.close();
                    is.close();
                }
            }
            //
        }catch (Exception e){
            e.printStackTrace();
        }
        return publish;
    }


}
