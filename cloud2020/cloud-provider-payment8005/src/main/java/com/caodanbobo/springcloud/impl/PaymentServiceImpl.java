package com.caodanbobo.springcloud.impl;

import com.caodanbobo.springcloud.dao.PaymentDao;
import com.caodanbobo.springcloud.entities.Payment;
import com.caodanbobo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author Liu Zhenbo
 * @Date 2020/6/18 14:38
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);

    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
