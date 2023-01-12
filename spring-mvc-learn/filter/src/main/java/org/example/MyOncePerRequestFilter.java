package org.example;

import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyOncePerRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpBodyContentRequestWrapper requestWrapper = new HttpBodyContentRequestWrapper(request);

        requestWrapper.setRequestBody("change by filter");
        filterChain.doFilter(requestWrapper, response);
    }

    private static class HttpBodyContentRequestWrapper extends HttpServletRequestWrapper {
        private byte[] requestBody = null;

        public void setRequestBody(String text) throws UnsupportedEncodingException {
            this.requestBody = text.getBytes(StandardCharsets.UTF_8);
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
