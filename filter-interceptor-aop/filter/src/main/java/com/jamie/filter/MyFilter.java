package com.jamie.filter;

import com.jamie.utils.BodyRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //修改header
//        ParametersRequestWrapper requestWrapper = new ParametersRequestWrapper(request);
//        requestWrapper.putHeader("token","123456");
//        filterChain.doFilter(requestWrapper, response);

        //修改body
        BodyRequestWrapper requestWrapper = new BodyRequestWrapper((HttpServletRequest) request, "500");
        filterChain.doFilter(requestWrapper, response);
    }
}
