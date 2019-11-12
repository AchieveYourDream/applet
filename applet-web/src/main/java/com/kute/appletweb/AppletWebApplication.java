package com.kute.appletweb;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.Properties;

@SpringBootApplication(scanBasePackages = {"com.kute"})
@MapperScan(basePackages = "com.kute.**.dao")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCaching
public class AppletWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppletWebApplication.class, args);
    }



    //覆盖默认的自动配置
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //修改默认的序列化规则
        //1.创建序列化规则对象
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
//        //2.更改默认的序列化规则
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        //设置使用哪个仓库
        LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) template.getConnectionFactory();
        jedisConnectionFactory.setDatabase(2);
        return template;

    }


    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
