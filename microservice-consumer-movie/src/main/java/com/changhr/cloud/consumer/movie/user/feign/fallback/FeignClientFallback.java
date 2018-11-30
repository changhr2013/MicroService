package com.changhr.cloud.consumer.movie.user.feign.fallback;

import com.changhr.cloud.consumer.movie.user.entity.User;
import com.changhr.cloud.consumer.movie.user.feign.UserFeignClient;
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
