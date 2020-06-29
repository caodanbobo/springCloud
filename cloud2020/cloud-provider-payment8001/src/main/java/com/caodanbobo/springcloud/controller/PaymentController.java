package com.caodanbobo.springcloud.controller;

import com.caodanbobo.springcloud.entities.CommonResult;
import com.caodanbobo.springcloud.entities.Payment;
import com.caodanbobo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/18 14:54
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payments")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult<>(200, "success, port:" + serverPort, result);
        } else {
            return new CommonResult<>(444, "fail, port:" + serverPort, result);
        }

    }

    @GetMapping(value = "/payments/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<Payment>(200, "success, port:" + serverPort, payment);
        } else {
            return new CommonResult<Payment>(400, "fail, port:" + serverPort);
        }
    }

    @GetMapping(value = "payments/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances
        ) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
