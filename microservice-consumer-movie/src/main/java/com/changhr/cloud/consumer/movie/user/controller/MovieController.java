package com.changhr.cloud.consumer.movie.user.controller;

import com.changhr.cloud.consumer.movie.user.entity.User;
import com.changhr.cloud.consumer.movie.user.feign.UserFeignClient;
import com.netflix.discovery.converters.Auto;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author changhr
 */
@RestController
public class MovieController {

    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
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
     * @return microservice-provider-user 服务的信息
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}
