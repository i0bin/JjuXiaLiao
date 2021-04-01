package com.i0bin.xial.dao.impl;

import com.i0bin.xial.bean.Publish;
import com.i0bin.xial.dao.PublishDao;
import com.i0bin.xial.util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author i0bin
 * @Filename PublishDaoImpl.java
 * @date 2021/4/1
 **/

public class PublishDaoImpl implements PublishDao {


    @Override
    public void insertPublish(Publish publish) {
        DBHelper db = new DBHelper("insert into publish(nickname,date,content_txt,content_img,sign) value(?,?,?,?,?)");
        try {
            db.pst.setString(1,publish.getNickname());
            db.pst.setString(2,publish.getDate());
            db.pst.setString(3,publish.getContent_txt());
            db.pst.setString(4,publish.getContent_img());
            db.pst.setString(5,publish.getSign());


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close();
        }

    }

    @Override
    public void deletePublish(String sign) {

    }

    @Override
    public List<Publish> queryAllPublish() {


//        实例化集合
        ArrayList<Publish> list = new ArrayList<>();
//        select publish.nickname,publish.date,publish.content_txt.publish_img,publish_sign,user.icon from publish,user where publish.nickname =user.nickname;
        DBHelper db = new DBHelper("select publish.nickname,publish.date,publish.content_txt,publish.content_img,publish.sign,user.icon from publish,user where publish.nickname=user.nickname;");
        try {
            ResultSet resultSet = db.pst.executeQuery();
            while (resultSet.next()){
                Publish publish = new Publish();
                publish.setNickname(resultSet.getString("nickname"));
                publish.setDate(resultSet.getString("date"));
                publish.setContent_txt(resultSet.getString("content_txt"));
                publish.setContent_img(resultSet.getString("content_img"));
                publish.setSign(resultSet.getString("sign"));
                publish.setIcon(resultSet.getString("icon"));
                list.add(publish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close();
        }

        return list;

    }

    @Override
    public List<Publish> queryNickPublish(String nickname) {
        return null;
    }
}
