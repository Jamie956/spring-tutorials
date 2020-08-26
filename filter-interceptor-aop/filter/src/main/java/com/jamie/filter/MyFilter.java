package com.jamie.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyFilter extends OncePerRequestFilter {
    private FormHttpMessageConverter formConverter = new AllEncompassingFormHttpMessageConverter();
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private Charset charset = DEFAULT_CHARSET;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取请求 body inputStream -> string
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
        MediaType contentType = inputMessage.getHeaders().getContentType();
        Charset charset = (contentType != null && contentType.getCharset() != null ? contentType.getCharset() : this.charset);
        String body = StreamUtils.copyToString(inputMessage.getBody(), charset);

        //string -> map
        Map<String, Object> paramMap = new ObjectMapper().readValue(body, new TypeReference<HashMap<String, Object>>() {
        });

        //修改body
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            entry.setValue("22222");
        }

        //map -> bytes -> byteArrayInputStream
        byte[] bytes = JSON.toJSONString(paramMap).getBytes(charset);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        //创建新的requestWrapper
        HttpServletRequestWrapper requestWrapper = new HttpPutBodyContentRequestWrapper(request, byteArrayInputStream);

        filterChain.doFilter(requestWrapper, response);
    }

    private static class HttpPutBodyContentRequestWrapper extends HttpServletRequestWrapper {
        private final ByteArrayInputStream byteArrayInputStream;

        public HttpPutBodyContentRequestWrapper(HttpServletRequest request, ByteArrayInputStream byteArrayInputStream) {
            super(request);
            this.byteArrayInputStream = byteArrayInputStream;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new ServletInputStream() {
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
                    return byteArrayInputStream.read();
                }
            };
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(getInputStream()));
        }

    }
}
