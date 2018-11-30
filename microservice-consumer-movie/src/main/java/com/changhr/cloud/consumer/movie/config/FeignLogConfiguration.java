package com.changhr.cloud.consumer.movie.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 日志
 *
 * @author changhr
 * @create 2018-11-30 15:13
 */
@Configuration
public class FeignLogConfiguration {

    /**
     * 设置 Feign 的日志级别
     *
     * NONE: 不记录任何日志
     * BASIC：仅记录请求方法、URL、响应状态代码以及执行时间
     * HEADERS：记录 BASIC 级别的基础上，记录请求和响应的 header
     * FULL：记录请求和响应的 header，body 和元数据
     * */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

}
