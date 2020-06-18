package com.caodanbobo.springcloud.service;

import com.caodanbobo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/18 14:35
 * @Version 1.0
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
