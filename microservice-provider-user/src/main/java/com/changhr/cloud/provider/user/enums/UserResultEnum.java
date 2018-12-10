package com.changhr.cloud.provider.user.enums;

/**
 * 返回视图状态枚举
 *
 * @author changhr
 * @create 2018-12-10 16:22
 */
public enum UserResultEnum implements ResultEnum {

    /** 返回结果枚举 */
    SUCCESS(0, "success"),
    PARAM_ERROR(10101, "[user center] parameter exception"),
    UNKNOWN_ERROR(10199, "[user center] unknown exception");

    private Integer code;

    private String message;

    UserResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
