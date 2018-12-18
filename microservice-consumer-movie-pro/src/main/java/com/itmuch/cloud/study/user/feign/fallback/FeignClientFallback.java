package com.itmuch.cloud.study.user.feign.fallback;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * Feign 熔断回退类
 * FeignClientFallback 也可以是 public class，没有区别
 *
 * @author changhr
 * @create 2018-11-30 17:07
 */
@Component
public class FeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }

}
