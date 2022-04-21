package com.mycom.gateway.fliter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.mycom.gateway.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author ：songdalin
 * @date ：2022-4-20 下午 04:11
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Slf4j
@Order(-1)
@Component
public class MyGlobalFilter implements GlobalFilter {

    /**
     *
     * 基于token权限认证
     *
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        log.info("path:{}",path);
        //过滤不需要拦截的url
        if(path.startsWith("/login")){
            Mono<Void> filter = chain.filter(exchange);
            return filter;
        }
        //token校验
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders header = request.getHeaders();
        String token = header.getFirst("token");
        System.out.println("token="+token);
        ServerHttpResponse response = exchange.getResponse();
        if (StringUtils.isBlank(token)) {
            System.out.println("token not found");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        final Map<String, Claim> claimMap = JWTUtils.parseJwt(token);
        /**
         *
         * nginx转发时默认会丢弃header中带下划线的参数，需要额外配置
         *
         *
         */
        if (claimMap == null || claimMap.get("USER_ID")==null
                || StringUtils.isBlank(claimMap.get("USER_ID").asString()) ) {
            System.out.println("token error");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //请求头塞入解析后的用户id
        ServerHttpRequest newRequest = exchange.getRequest().mutate()
                .header("USER_ID", claimMap.get("USER_ID").asString())
                .build();
        return chain.filter(exchange.mutate().request(newRequest).build());
    }
}
