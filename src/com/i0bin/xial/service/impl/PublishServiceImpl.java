package com.i0bin.xial.service.impl;


import com.google.gson.Gson;
import com.i0bin.xial.bean.Publish;
import com.i0bin.xial.dao.PublishDao;
import com.i0bin.xial.dao.impl.PublishDaoImpl;
import com.i0bin.xial.service.PublishService;
import com.i0bin.xial.util.Result;
import com.i0bin.xial.util.upload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author i0bin
 * @Filename PublishServiceImpl.java
 * @date 2021/4/1
 **/

public class PublishServiceImpl implements PublishService {


    @Override
    public String Upload(HttpServletRequest req) {
        Result result = new Result();
//        获取对应的真实路径
        String path = req.getServletContext().getRealPath("/icon");
        Publish publish = new upload().upload_file(path,req);
//
        if (publish.getContent_txt().equals("")){
            result.setStatus("error");
            result.setMessage("内容不能为空");
        }else {
            new PublishDaoImpl().insertPublish(publish);
            result.setStatus("success");
            result.setMessage("发表成功");
            result.setTotal(new Gson().toJson(publish));
        }
        return new Gson().toJson(result);


    }

    @Override
    public String queryByPublish() {

        Result result = new Result();
        List<Publish> list = new PublishDaoImpl().queryAllPublish();
        System.out.println(list);
        if (list.size()!=0){
            result.setStatus("success");
            result.setMessage("获取成功");
            result.setTotal(new Gson().toJson(list));
        }else {
            result.setStatus("error");
            result.setMessage("没有发表的瞎聊");
        }
        return new Gson().toJson(result);
    }

    @Override
    public String queryNickname(String nickname) {
        return null;
    }

    @Override
    public String deletePublish(String sign) {
        return null;
    }
}
