package com.i0bin.xial.dao;

import com.i0bin.xial.bean.Publish;

import java.util.List;

public interface PublishDao {
    //    添加
    public void insertPublish(Publish publish);

    //    删除  发布的标识号
    public void deletePublish(String sign);

    //    查询所有数据
    public List<Publish> queryAllPublish();

    //    根据昵称查询发表的内容
    public List<Publish> queryNickPublish(String nickname);


}
