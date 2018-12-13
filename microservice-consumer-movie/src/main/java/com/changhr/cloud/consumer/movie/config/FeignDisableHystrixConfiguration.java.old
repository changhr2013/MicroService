package com.changhr.cloud.consumer.movie.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 为指定 Feign 客户端禁用 Hystrix
 *
 * 1. 想要禁用 Hystrix 的 @FeignClient 引用该配置类即可
 *    [@FeignClient(name = "user", configuration = FeignDisableHystrixConfiguration.class)]
 *
 * 2. 全局禁用 Hystrix
 *    只需在application.yml 中配置 feign.hystrix.enabled = false
 *
 * @author changhr
 */
@Configuration
public class FeignDisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
