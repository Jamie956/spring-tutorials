package com.jamie.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.Map;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 进入Controller层之前拦截请求，默认是拦截所有请求
     * @return 是否拦截当前请求，true表示拦截当前请求，false表示不拦截当前请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        //获取请求路径
        String requestURI = request.getRequestURI();
        // 获取请求path variable参数
        Map<String, String[]> ParameterMap = request.getParameterMap();


        // 获取RequestBody参数
//        HttpBodyContentRequestWrapper requestWrapper = new HttpBodyContentRequestWrapper(request);

        //获取类注解
        Annotation clazzAnnotation = ((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(RequestMapping.class);
        //获取方法注解
        Annotation methodAnnotation = ((HandlerMethod) handler).getMethod().getAnnotation(PostMapping.class);

        return true;
    }

    /**
     * 处理完请求后但还未渲染视图之前进行的操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * 视图渲染后但还未返回到客户端时的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

    private static class HttpBodyContentRequestWrapper extends HttpServletRequestWrapper {
        private byte[] requestBody = null;

        public JSONObject getRequestBody() throws UnsupportedEncodingException {
            return JSON.parseObject((new String(requestBody, "UTF-8")));
        }

        public void setRequestBody(JSONObject jsonObject) throws UnsupportedEncodingException {
            this.requestBody = jsonObject.toJSONString().getBytes("UTF-8");
        }

        public HttpBodyContentRequestWrapper(HttpServletRequest request) {
            super(request);
            try {
                requestBody = StreamUtils.copyToByteArray(request.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public ServletInputStream getInputStream() {
            if (requestBody == null) {
                requestBody = new byte[0];
            }
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);

            return new ServletInputStream() {
                @Override
                public int read() throws IOException {
                    return byteArrayInputStream.read();
                }

                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener listener) {

                }
            };
        }
        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(getInputStream()));
        }
    }
}
