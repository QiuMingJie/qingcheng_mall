package com.qingcheng.entity;

import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-06 21:10
 * @Description
 */
public class Result implements Serializable {

    /**
     *    业务返回码 0：成功 1错误
     */
    private Integer code;

    private String message;

    public Result() {
        this.code = 0;
        this.message = "执行成功";
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
