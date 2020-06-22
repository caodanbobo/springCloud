package com.caodanbobo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentMain8001
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/18 11:19
 * @Version 1.0
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8007.class, args);
    }
}
