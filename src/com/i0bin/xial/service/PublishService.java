package com.i0bin.xial.service;

import javax.servlet.http.HttpServletRequest;

public interface PublishService {
    //    发表业务
    public String Upload(HttpServletRequest req);

    //    查询所有用户
    public String queryByPublish();

    //    个人发表查询
    public String queryNickname(String nickname);

    //    删除个人的
    public String deletePublish(String sign);
}
