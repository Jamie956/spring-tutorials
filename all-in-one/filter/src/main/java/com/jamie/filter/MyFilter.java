package com.jamie.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/*"}, filterName = "myFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("dofilter before");

        HttpServletRequest HRrequest = (HttpServletRequest) request;


        // 当前过滤器处理完了交给下一个过滤器处理
        chain.doFilter(request, response);

        System.out.println("dofilter after");

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
