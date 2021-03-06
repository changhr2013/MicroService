package com.changhr.cloud.study.user.config;

import com.changhr.cloud.study.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 RibbonClient，为特定 name 的 Ribbon Client 自定义配置
 * 使用 @RibbonClient 的 configuration 属性，指定 Ribbon 的配置类
 *
 * @author changhr
 */
@Configuration
@RibbonClient(name = "microservice-provider-user"
        , configuration = RibbonConfiguration.class
)
public class UserProviderBalanceConfiguration {
}
