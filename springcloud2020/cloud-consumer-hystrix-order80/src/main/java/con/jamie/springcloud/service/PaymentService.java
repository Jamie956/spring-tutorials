package con.jamie.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String providerOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/notimeout/{id}")
    String providerNoTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String providerTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/exception/{id}")
    String providerException(@PathVariable("id") Integer id);
}