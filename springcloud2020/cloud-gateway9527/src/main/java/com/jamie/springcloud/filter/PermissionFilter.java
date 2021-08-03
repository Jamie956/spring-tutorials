package com.jamie.springcloud.filter;


import com.alibaba.fastjson.JSONObject;
import com.jamie.springcloud.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class PermissionFilter implements GlobalFilter, Ordered {
    private static final List<String> IGNORE_LOGIN_PATTERN = Arrays.asList("/guonei", "/payment", "/payment/**");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.debug("进入 PermissionFilter");

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取url
        String url = request.getURI().getPath();

        //忽略登录url 放行
        AntPathMatcher matcher = new AntPathMatcher();
        for (String pattern : IGNORE_LOGIN_PATTERN) {
            if (matcher.match(pattern, url)) {
                log.info("{} 与 {} 匹配", pattern, url);
            } else {
                log.info("{} 与 {} 不匹配", pattern, url);
            }
        }

        //获取token
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        //token 不存在
        if (token == null) {
            log.info("参数缺少 token, 鉴权失败!");
            //自定义返回结果
            JSONObject message = new JSONObject();
            message.put("status", -1);
            message.put("data", "参数缺少 token 鉴权失败");
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }

        Claims claims = null;
        try {
            claims = JwtUtil.getClaimsFromToken(token);
        } catch (Exception e) {
            log.info("签名异常");
            e.printStackTrace();

            JSONObject message = new JSONObject();
            message.put("status", -1);
            message.put("data", "签名异常");
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
        String userName = claims.getSubject();

        //设置用户名到请求头
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 4;
    }
}