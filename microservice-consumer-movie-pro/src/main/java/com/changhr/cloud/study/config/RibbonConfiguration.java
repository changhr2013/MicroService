package com.changhr.cloud.study.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon 的配置类
 * 注意：该类不应该在主应用程序上下文的 @ComponentScan 中
 * @author changhr
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        // 负载均衡规则，改为随机
        return new RandomRule();
//        return new BestAvailableRule();
    }
}
