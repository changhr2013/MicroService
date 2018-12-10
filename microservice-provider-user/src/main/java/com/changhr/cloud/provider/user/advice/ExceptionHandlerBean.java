package com.changhr.cloud.provider.user.advice;

import com.alibaba.fastjson.JSON;
import com.changhr.cloud.provider.user.enums.UserResultEnum;
import com.changhr.cloud.provider.user.exception.ParameterException;
import com.changhr.cloud.provider.user.vo.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常捕获
 *
 * @author changhr
 * @create 2018-12-10 16:03
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerBean extends ResponseEntityExceptionHandler {

    /**
     * 参数
     * @param ex        运行时异常
     * @param request   请求
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ParameterException.class})
    public ResponseEntity<Object> handleParamException(RuntimeException ex, WebRequest request) {
        return getResponseEntity(ex, request, UserResultEnum.PARAM_ERROR);
    }

    /**
     * 根据各种异常构建 ResponseEntity 实体，服务于以上各种异常
     * @param ex            运行时异常
     * @param request       请求
     * @param resultEnum    异常结果枚举
     * @return ResponseEntity<Object>
     */
    public ResponseEntity<Object> getResponseEntity(RuntimeException ex,
                                                    WebRequest request,
                                                    UserResultEnum resultEnum){
        ResultData resultData = new ResultData();
        resultData.setCode(resultEnum.getCode());
        resultData.setMessage(resultData.getMessage());
        String resultJson = JSON.toJSONString(resultData);
        logger.error("异常信息: ", ex);

        return handleExceptionInternal(ex, resultJson, new HttpHeaders(), HttpStatus.OK, request);
    }
}
