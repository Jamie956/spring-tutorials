package com.jamie.filter;

import com.jamie.utils.BodyRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//@Order(100)//括号中的数字越大，在多个过滤器的执行顺序越靠前
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //修改header
//        ParametersRequestWrapper requestWrapper = new ParametersRequestWrapper(request);
//        requestWrapper.putHeader("token","123456");
//        filterChain.doFilter(requestWrapper, response);

        //修改参数
//        HttpServletRequest requestWrapper = new BodyRequestWrapper(request);
//        filterChain.doFilter(requestWrapper, response);

        //修改body
        BodyRequestWrapper requestWrapper = new BodyRequestWrapper((HttpServletRequest) request);
        filterChain.doFilter(requestWrapper, response);
    }
}
