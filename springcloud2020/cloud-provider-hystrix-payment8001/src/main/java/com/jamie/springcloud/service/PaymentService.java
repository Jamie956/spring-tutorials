package com.jamie.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String providerOK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  成功访问";
    }

    /**
     * 耗时任务消耗3秒，等待时间有5秒，服务提供者不会熔断
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String providerNoTimeOut(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " 耗时任务成功执行";
    }

    /**
     * 耗时任务消耗3秒，而等待时间只有1秒，服务提供者会熔断
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String providerTimeOut(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " 耗时任务成功执行";
    }

    @HystrixCommand(fallbackMethod = "exceptionHandler")
    public String providerException(Integer id) {
        int age = 10 / 0;
        return "线程池:  " + Thread.currentThread().getName() + " 任务成功执行";
    }

    public String timeOutHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  超时了！来自服务提供者的错误提示";
    }

    public String exceptionHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  异常了！来自服务提供者的错误提示";
    }

}