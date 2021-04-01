package com.i0bin.xial.bean;

import java.util.Date;

/**
 * @author i0bin
 * @Filename Publish.java
 * @date 2021/4/1
 **/

public class Publish {
    private int id;
    private String nickname;
    private String date;
    private String content_txt;
    private String content_img;
    private String icon;
    private String sign;


    public Publish(int id, String nickname, String date, String content_txt, String content_img, String icon, String sign) {
        this.id = id;
        this.nickname = nickname;
        this.date = date;
        this.content_txt = content_txt;
        this.content_img = content_img;
        this.icon = icon;
        this.sign = sign;
    }

    public Publish() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent_txt() {
        return content_txt;
    }

    public void setContent_txt(String content_txt) {
        this.content_txt = content_txt;
    }

    public String getContent_img() {
        return content_img;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}