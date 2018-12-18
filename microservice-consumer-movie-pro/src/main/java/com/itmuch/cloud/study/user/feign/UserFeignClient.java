package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.config.FeignLogConfiguration;
import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.fallback.FeignClientFallbackFactory;
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
@FeignClient(name = "microservice-provider-user"
            , configuration = FeignLogConfiguration.class
            , fallbackFactory = FeignClientFallbackFactory.class
)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}

