package com.example.demo.entity;

import lombok.Data;

@Data
public class Result<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private Boolean success;
    private String url;
    private T data;

//    private Map<String, Object> data = new HashMap<>();

//    //把构造方法私有
//    public Result() {
//    }

    //成功静态方法
//    public static Result ok() {
//        Result r = new Result();
//        r.setSuccess(true);
//        r.setCode(OK);
//        r.setMessage("成功");
//        return r;
//    }

    public Result<T> ok() {
//        Result r = new Result();
        this.setSuccess(true);
        this.setCode(OK);
        this.setMessage("成功");
        return this;
    }

    //失败静态方法
    public static Result<?> error() {
        Result<?> result = new Result<>();
        result.setSuccess(false);
        result.setCode(ERROR);
        result.setData(null);
        result.setMessage("失败");
        return result;
    }

    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result url(String url) {
        this.setUrl(url);
        return this;
    }

//    public Result data(String key, Object value) {
//        this.data.put(key, value);
//        return this;
//    }
//
//    public Result data(Map<String, Object> map) {
//        this.setData(map);
//        return this;
//    }
}