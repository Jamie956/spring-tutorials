package com.jamie.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //构造RequestWrapper，并将输入流转成byte[]，存到变量requestBody
        HttpBodyContentRequestWrapper requestWrapper = new HttpBodyContentRequestWrapper(request);
        //获取body json，将body byte[]转换成json
        JSONObject json = requestWrapper.getRequestBody();

        //更改body，将json 转成 body byte[]
        requestWrapper.setRequestBody(JSON.parseObject("{'id':2,'greet':'update'}"));

        filterChain.doFilter(requestWrapper, response);
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
