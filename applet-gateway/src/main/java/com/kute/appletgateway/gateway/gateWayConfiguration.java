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
                .route("goodsRouter", r -> r.path("/goods/**")
                        .uri("lb://applet-goods")
                )
                //小程序登陆接口
                .route("appletLoginRouter", r -> r.path("/api/login")
                        .filters(f -> f.filter(new IgnoreTestGlobalFilterFactor()))
                        .uri("lb://applet-web")
                )
                //小程序获取登陆验证码
                .route("verificationRouter", r -> r.path("/api/getVerificationCode")
                        .filters(f -> f.filter(new IgnoreTestGlobalFilterFactor()))
                        .uri("lb://applet-web")
                )

                //web(需要验证token)
                .route("webRouter", r -> r.path("/api/**")
                        .uri("lb://applet-web")
                )
                //咨询信息(无需验证token)
                .route("informationRouter", r -> r.path("/appInformation/**")
                        .filters(f -> f.filter(new IgnoreTestGlobalFilterFactor()))
                        .uri("lb://applet-goods")
                )
                //商品信息(无需验证token)
                .route("goodsOpenRouter", r -> r.path("/appGoods/**")
                        .filters(f -> f.filter(new IgnoreTestGlobalFilterFactor()))
                        .uri("lb://applet-goods")
                )
                //web登陆接口
                .route("webLoginRouter", r -> r.path("/login")
                        .filters(f -> f.filter(new IgnoreTestGlobalFilterFactor()))
                        .uri("lb://applet-manage")
                )

                //静态接口
                .route("staticRouter", r -> r.path("/static/**")
                        .filters(f -> f.filter(new IgnoreTestGlobalFilterFactor()))
                        .uri("lb://applet-static")
                )
                .build();
    }
}
