package com.changhr.cloud.consumer.movie.config;

import feign.Contract;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为 Feign 的配置类
 * 注意：该类不应该在主应用程序上下文的 @ComponentScan 中
 * @author changhr
 */
@Configuration
public class FeignConfiguration {

    /**
     * 将契约改为 feign 原生的默认契约。这样就可以使用 feign 自带的注解了
     * @return 默认的 feign 契约
     */
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
