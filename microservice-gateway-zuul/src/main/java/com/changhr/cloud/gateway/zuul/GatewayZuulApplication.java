package com.changhr.cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 在启动类上添加注解 @EnableZuulProxy, 声明一个 Zuul 代理。
 * 该代理使用 Ribbon 来定位注册在 Eureka Server 中的微服务；
 * 同时，该代理还整合了 Hystrix，从而实现了容错，
 * 所有经过 Zuul 的请求都会在 Hystrix 命令中执行。
 *
 * @author changhr
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
