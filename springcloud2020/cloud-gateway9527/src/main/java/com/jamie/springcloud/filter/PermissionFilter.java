package com.jamie.springcloud.filter;

import com.jamie.springcloud.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class PermissionFilter implements GlobalFilter, Ordered {
    private static final List<String> USER_PERMISSION = Arrays.asList("/payment/get/1", "/payment/get");
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入 PermissionFilter");
        //获取token 参数，获取用户名，查询用户的权限
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null) {
            System.out.println("鉴权失败");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        Claims claims = JwtUtil.getClaimsFromToken(token.substring(7));
        String userName= claims.getSubject();
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        if (!"tom".equals(userName) || !USER_PERMISSION.contains(url)) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            System.out.println("鉴权失败");
            return exchange.getResponse().setComplete();
        }
        System.out.println("鉴权成功");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 4;
    }
}