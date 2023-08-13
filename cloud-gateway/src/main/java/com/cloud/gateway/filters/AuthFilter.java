package com.cloud.gateway.filters;

import com.cloud.common.constants.TokenConstants;
import com.cloud.common.utils.JwtUtils;
import com.cloud.common.utils.StringUtils;
import com.cloud.gateway.config.IgnoreWhiteConfig;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 网关过滤器
 *
 * @BelongsProject: SpringBootCloud
 * @BelongsPackage: com.cloud.gateway.filters
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-13  12:11
 * @Description: //TODO 网关过滤器
 * @Version: 1.0
 */
@Component
@AllArgsConstructor
public class AuthFilter implements GlobalFilter, Ordered {

    private final IgnoreWhiteConfig ignoreWhiteConfig;
    private final RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //白名单校验
        List<String> whites = ignoreWhiteConfig.getWhites();
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if (StringUtils.matches(path,whites)){
            return chain.filter(exchange);
        }

        //token非空校验
        String token = request.getHeaders().getFirst(TokenConstants.TOKEN);
        if (StringUtils.isEmpty(token)){
            throw new RuntimeException("token不能为空!");
        }

        //token合法校验
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            throw new RuntimeException("token不合法!");
        }

        //token有效校验
        String userKey = JwtUtils.getUserKey(token);
        Boolean hasKey = redisTemplate.hasKey(TokenConstants.LOGIN_TOKEN_KEY + userKey);
        if (!hasKey){
            throw new RuntimeException("token过期!");
        }

        //校验通过====>放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
