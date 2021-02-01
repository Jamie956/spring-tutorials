package com.example.demo.exception;

import com.example.demo.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 拦截自定义异常，全局异常处理
     * @param req 请求信息
     * @param e 捕获的指定异常
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result<?> myExceptionHandler(HttpServletRequest req, MyException e) {
        return Result.error().message(e.getMessage()).url(req.getRequestURL().toString());
    }

}

