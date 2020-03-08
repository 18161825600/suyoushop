package com.kxg.suyoushop.common;

public class ShopJsonResult<T> {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok; // 不使用


    public static ShopJsonResult build(Integer status, String msg, Object data) {
        return new ShopJsonResult(status, msg, data);
    }

    public static ShopJsonResult ok(Object data) {
        return new ShopJsonResult(data);
    }

    public static ShopJsonResult ok() {
        return new ShopJsonResult(null);
    }

    public static ShopJsonResult errorMsg(String msg) {
        return new ShopJsonResult(500, msg, null);
    }

    public static ShopJsonResult errorMap(Object data) {
        return new ShopJsonResult(501, "error", data);
    }

    public static ShopJsonResult errorTokenMsg(String msg) {
        return new ShopJsonResult(502, msg, null);
    }

    public static ShopJsonResult errorException(String msg) {
        return new ShopJsonResult(555, msg, null);
    }

    public ShopJsonResult() {

    }

    public ShopJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ShopJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}

