package com.lanlinker.study.entity;

/**
 * Created by MetalSteel on 2017/8/29.
 */
public class Msg {
    private Integer code;
    private String msg;

    public Msg() {
    }

    public Msg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
