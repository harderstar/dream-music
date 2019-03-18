package com.simdy.cms.entity;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/18 11:12
 * @Version 1.0
 **/
public class Result implements Serializable {
    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
