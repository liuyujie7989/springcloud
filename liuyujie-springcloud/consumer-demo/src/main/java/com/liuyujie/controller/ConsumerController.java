package com.liuyujie.controller;

import com.liuyujie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liuyishou
 * @date 2020/6/15
 */

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    /**
     *Spring提供了一个RestTemplate模板工具类，对基于Http的客户端进行了封装，并且实现了对象与json的序列化和 反序列化，非常方便。
     * RestTemplate并没有限定Http的客户端类型，而是进行了抽象，目前常用的3种都有支持：
     * HttpClient
     * OkHttp
     * DK原生的URLConnection（默认的）
     */

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id) {
        String url = "http://localhost:9091/user/"+id;

        //获取eureka中注册的user-service实例列表
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
        System.out.println(url);
        return restTemplate.getForObject(url,User.class);
    }
}
