package com.i0bin.xial.util;

import java.util.List;

/**
 * @Author: Bug小能手
 * @NAME:mi
 * @Date: 2020/12/22 15:22
 * @Description:
 */

//信息管理工具类

public class Result {

    private String status="success";
    private String message = "";
    private String total = "";
    private List item = null;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List getItem() {
        return item;
    }

    public void setItem(List item) {
        this.item = item;
    }
}
