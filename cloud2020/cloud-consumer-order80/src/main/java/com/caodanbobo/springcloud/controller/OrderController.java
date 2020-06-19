package com.caodanbobo.springcloud.controller;

import com.caodanbobo.springcloud.entities.CommonResult;
import com.caodanbobo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/18 16:11
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate template;

    @PostMapping("/consumer/payments")
    public CommonResult<Payment> create(Payment payment){
        return template.postForObject(PAYMENT_URL+"/payments",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payments/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") String id){
        return template.getForObject(PAYMENT_URL+"/payments/"+id,CommonResult.class);
    }
}
