package com.kute.appletmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.kute"})
@MapperScan(basePackages = "com.kute.**.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class AppletGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppletGoodsApplication.class, args);
    }

}
