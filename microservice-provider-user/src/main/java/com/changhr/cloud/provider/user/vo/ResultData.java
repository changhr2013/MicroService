package com.changhr.cloud.provider.user.vo;

/**
 * 返回视图模板类
 *
 * @author changhr
 * @create 2018-12-10 16:19
 */
public class ResultData<T> {

    private Integer code;

    private String message;

    private T data;

    public ResultData() {
    }

    public ResultData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
