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
//        ModifyParametersWrapper mParametersWrapper = new ModifyParametersWrapper(request);
//        mParametersWrapper.putHeader("token","123456");
//        filterChain.doFilter(mParametersWrapper, response);

        //修改参数
        HttpServletRequest wrapper = new BodyRequestWrapper(request);//定义一个新的request（名称是wrapper），
        filterChain.doFilter(wrapper, response);//将修改过的request（wrapper）放回
    }
}
