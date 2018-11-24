package com.lrs.admin.dao.domain;

public class ParamException extends Throwable {
    private int code;
    private String msg;
    public ParamException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
