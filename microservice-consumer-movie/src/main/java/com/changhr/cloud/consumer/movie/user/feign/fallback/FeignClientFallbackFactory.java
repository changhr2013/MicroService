package com.changhr.cloud.consumer.movie.user.feign.fallback;

import com.changhr.cloud.consumer.movie.user.entity.User;
import com.changhr.cloud.consumer.movie.user.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * UserFeignClient 的 fallbackFactory 类，该类需实现 FallbackFactory 接口，并覆写 create 方法
 * @author changhr
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallback.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                // 日志最好放在各个 fallback 方法中，而不要直接放在 create 方法中。
                // 否则在引用启动时，就会打印该日志。
                // 详见 https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
                FeignClientFallbackFactory.logger.info("fallback; reason was:", cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }
        };
    }
}
