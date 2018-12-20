package com.changhr.cloud.study.user.feign;

import com.changhr.cloud.study.user.feign.fallback.FeignClientFallbackFactory;
import com.changhr.cloud.study.config.FeignLogConfiguration;
import com.changhr.cloud.study.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * microservice-provider-user 的 Feign 接口
 * <p>
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

