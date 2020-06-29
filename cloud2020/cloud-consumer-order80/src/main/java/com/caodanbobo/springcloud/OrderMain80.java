package com.caodanbobo.springcloud;

import com.ribbinRule.RibbonConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
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
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RibbonConf.class)
public class OrderMain80 {
    @Bean
    //@LoadBalanced 使用ribbion
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
