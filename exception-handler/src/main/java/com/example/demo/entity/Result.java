package com.example.demo.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result<T> ok() {
        this.setCode(HttpStatus.OK.value());
        this.setMessage("成功");
        return this;
    }

    public Result<T> error() {
        this.setCode(HttpStatus.BAD_REQUEST.value());
        this.setMessage("失败");
        return this;
    }

    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

}