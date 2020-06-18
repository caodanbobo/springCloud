package com.caodanbobo.springcloud.controller;

import com.caodanbobo.springcloud.entities.CommonResult;
import com.caodanbobo.springcloud.entities.Payment;
import com.caodanbobo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payments")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult<>(200,"success",result);
        }else {
            return new CommonResult<>(444,"fail",result);
        }

    }
    @GetMapping(value = "/payments/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        if(payment!=null) {
            return new CommonResult<Payment>(200, "success", payment);
        }else {
            return new CommonResult<Payment>(400, "fail");
        }
    }
}
