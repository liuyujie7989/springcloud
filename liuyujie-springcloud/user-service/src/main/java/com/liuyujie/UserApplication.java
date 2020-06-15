package com.liuyujie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liuyishou
 * @date 2020/6/15
 */

@SpringBootApplication
//通过添加 @EnableDiscoveryClient 开启Eureka客户端发现功能
@EnableDiscoveryClient
@MapperScan("com.liuyujie.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

}
