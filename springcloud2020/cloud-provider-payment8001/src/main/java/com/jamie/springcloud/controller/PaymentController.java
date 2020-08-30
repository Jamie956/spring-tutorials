package com.jamie.springcloud.controller;

import com.jamie.springcloud.entities.CommonResult;
import com.jamie.springcloud.entities.Payment;
import com.jamie.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //http://localhost:8001/payment/create
    /*
    {
        "id": 2,
        "serial": "shake"
    }    
     */
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int ret = paymentService.create(payment);
        if (ret > 0) {
            return new CommonResult(200, "success", ret);
        } else {
            return new CommonResult(404, "failed", null);
        }
    }

    //http://localhost:8001/payment/get/1
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(404, "failed", null);
        }
    }
}
