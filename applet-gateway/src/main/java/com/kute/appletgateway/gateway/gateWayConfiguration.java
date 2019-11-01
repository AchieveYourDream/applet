package com.kute.appletgateway.gateway;

import com.kute.appletgateway.filter.IgnoreTestGlobalFilterFactor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
@Component
public class gateWayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            //所有后台管理路径
            .route("userRouter", r -> r.path("/app/**")
                    .uri("lb://applet-manage")
            )
            //商品信息(需要验证token)
            .route("orderRouter", r -> r.path("/api/goods/**")
                    .uri("lb://applet-goods")
            )
            //商品信息(无需验证token)
            .route("orderRouter", r -> r.path("/open/goods/**")
                    .filters(f->f.filter(new IgnoreTestGlobalFilterFactor()))
                    .uri("lb://applet-goods")
            )
            //登陆接口
            .route("orderRouter", r -> r.path("/login")
                    .filters(f->f.filter(new IgnoreTestGlobalFilterFactor()))
                    .uri("lb://applet-manage")
            )
            .build();
    }
}
