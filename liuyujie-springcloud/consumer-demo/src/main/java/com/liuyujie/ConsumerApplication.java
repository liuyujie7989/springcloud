package com.liuyujie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuyishou
 * @date 2020/6/15
 */

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
