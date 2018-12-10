package com.changhr.cloud.provider.user.exception;

import com.changhr.cloud.provider.user.enums.UserResultEnum;

/**
 * 参数异常
 *
 * @author changhr
 * @create 2018-12-10 16:33
 */
public class ParameterException extends UserApplicationException {
    private Integer code;

    public ParameterException() {
    }

    public ParameterException(Integer code, String message) {
        super(code, message);
    }

    public ParameterException(UserResultEnum resultEnum) {
        super(resultEnum);
    }
}
