package com.caodanbobo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderMain80
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/18 16:07
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}
