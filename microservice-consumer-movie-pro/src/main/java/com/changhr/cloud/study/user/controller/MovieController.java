package com.changhr.cloud.study.user.controller;

import com.changhr.cloud.study.user.entity.User;
import com.changhr.cloud.study.user.feign.UserFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author changhr
 */
@RestController
@Api("MovieController 相关的 API")
public class MovieController {

    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @ApiOperation(value = "根据 Id 查询用户信息", notes = "查询数据库中某个用户的信息")
    @ApiImplicitParam(name = "id", value = "用户 ID", paramType = "path", required = true, dataType = "Long")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        logger.info("{}:{}:{}", serviceInstance.getServiceId(),
                serviceInstance.getHost(), serviceInstance.getPort());
    }

    /**
     * 查询 microservice-provider-user 服务的信息并返回
     *
     * @return microservice-provider-user 服务的信息
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}
