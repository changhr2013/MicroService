package com.changhr.cloud.consumer.movie.user.feign;

import com.changhr.cloud.consumer.movie.config.FeignConfiguration;
import com.changhr.cloud.consumer.movie.user.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * microservice-provider-user 的 Feign 接口
 *
 * 2. 使用 @FeignClient 的 configuration 属性，指定 feign 的配置类
 *
 * @author changhr
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    User findById(@PathVariable("id") Long id);

    /**
     * 使用 feign 自带的注解 @RequestLine
     * @param id    用户 Id
     * @return User 用户信息
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
