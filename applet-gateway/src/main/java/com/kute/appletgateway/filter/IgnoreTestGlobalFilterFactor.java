package com.kute.appletgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClaseName 不拦截指定路径
 * @Auther 王斌
 * @Date
 **/
@Component
public class IgnoreTestGlobalFilterFactor extends AbstractGatewayFilterFactory<IgnoreTestGlobalFilterFactor.Config> implements GatewayFilter {

    public IgnoreTestGlobalFilterFactor() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return this::filter;
    }

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(AuthorizeFilter.ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER, true);

        return chain.filter(exchange);
    }

    public static class Config {

    }

    @Override
    public String name() {
        return "IgnoreTestGlobalFilter";
    }
}