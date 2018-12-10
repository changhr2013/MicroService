package com.changhr.cloud.provider.user.utils;

import com.changhr.cloud.provider.user.enums.UserResultEnum;
import com.changhr.cloud.provider.user.vo.ResultData;

/**
 * 返回视图工具类
 *
 * @author changhr
 * @create 2018-12-10 17:31
 */
public class ResultDataUtil {

    public static ResultData<Object> success(Object data) {
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(UserResultEnum.SUCCESS.getCode());
        resultData.setMessage(UserResultEnum.SUCCESS.getMessage());
        if(data != null){
            resultData.setData(data);
        }
        return resultData;
    }

    public static ResultData<Object> success(){
        return success(null);
    }

    public static ResultData error(Integer code, String message) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

    public static ResultData error(UserResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMessage());
    }
}
