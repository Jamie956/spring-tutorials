package com.jamie.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BodyRequestWrapper extends HttpServletRequestWrapper {
    private final String dataPermission;

    public BodyRequestWrapper(HttpServletRequest request, String dataPermission) {
        super(request);
        this.dataPermission = dataPermission;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        //非json类型，直接返回
        if (!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            return super.getInputStream();
        }
        //从输入流中取出body串, 如果为空，直接返回
        String reqBodyStr = IOUtils.toString(super.getInputStream(), "utf-8");
        if (StringUtils.isEmpty(reqBodyStr)) {
            return super.getInputStream();
        }
        //reqBodyStr转为Map对象
        Map<String, Object> paramMap = new ObjectMapper().readValue(reqBodyStr, new TypeReference<HashMap<String, Object>>() {
        });

        //修改参数
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            entry.setValue(dataPermission);
        }

        //重新构造一个输入流对象
        byte[] bytes = JSON.toJSONString(paramMap).getBytes("utf-8");
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);


        ServletInputStream servletInputStream = new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }

            @Override
            public int read() throws IOException {
                return bis.read();
            }
        };
        return servletInputStream;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}