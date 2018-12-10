package com.changhr.cloud.provider.user.exception;

import com.changhr.cloud.provider.user.enums.UserResultEnum;

/**
 * 用户中心异常
 *
 * @author changhr
 * @create 2018-12-10 17:47
 */
public class UserApplicationException extends RuntimeException {

    private Integer code;

    public UserApplicationException() {
    }

    public UserApplicationException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public UserApplicationException(UserResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
