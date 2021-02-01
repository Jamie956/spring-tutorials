package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    /**
     * 触发 CustomException 异常
     * http://localhost:8080/t1?num=
     * {"code":400,"message":"num不能为空","data":null}
     *
     * 成功 不触发异常
     * http://localhost:8080/t1?num=5
     * {"code":200,"message":"成功","data":null}
     *
     * 触发 ArithmeticException -> RuntimeException 异常
     * http://localhost:8080/t1?num=0
     * {"code":400,"message":"/ by zero","data":null}
     *
     * @param num
     * @return
     */
    @GetMapping("/t1")
    public Result<?> t1(@RequestParam Integer num) {
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        int i = 10 / num;
        return new Result<>().ok();
    }

}