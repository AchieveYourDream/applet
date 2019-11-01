package com.kute.appletgateway.filter;

import com.kute.appletgateway.jwt.JWTTokenUtil;
import io.netty.buffer.ByteBufAllocator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

/**
 * token校验全局过滤器
 * @Version V1.0
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    public final static String ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER = "@ignoreTestGlobalFilter";
    /**
     * 指定该Filter的类型
     */
    @Value("${jwt.secret}")
    private String secret;


    @Value("${jwt.expiration}")
    private String expiration;


//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        if (exchange.getAttribute(ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER) != null) {
            return chain.filter(exchange);
        }


        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String method = serverHttpRequest.getMethodValue();

        String authToken = serverHttpRequest.getHeaders().getFirst("Authorization");


        if (authToken == null || !JWTTokenUtil.validateToken(secret, authToken)) {
            byte[] bits = "您没有访问权限".getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        } else {
            if (JWTTokenUtil.isRefreshToken(secret, expiration, authToken)) {
                String refreshToken = JWTTokenUtil.refreshToken(secret, expiration, authToken);
                System.out.println(refreshToken);
                response.getHeaders().add("refreshToken", refreshToken);
            }
            if ("POST".equals(method)) {
                //从请求里获取Post请求体
                String bodyStr = resolveBodyFromRequest(serverHttpRequest);
                //TODO 得到Post请求的请求参数后，做你想做的事



                //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
                URI uri = serverHttpRequest.getURI();
                ServerHttpRequest request = serverHttpRequest.mutate().uri(uri).build();
                DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
                Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);

                request = new ServerHttpRequestDecorator(request) {
                    @Override
                    public Flux<DataBuffer> getBody() {
                        return bodyFlux;
                    }
                };
                //封装request，传给下一级
                return chain.filter(exchange.mutate().request(request).build());
            } else if ("GET".equals(method)) {
                return chain.filter(exchange);
            }
        }
        return chain.filter(exchange);

    }
    /**
     * 从Flux<DataBuffer>中获取字符串的方法
     * @return 请求体
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();

        AtomicReference<String> bodyRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyRef.set(charBuffer.toString());
        });
        //获取request body
        return bodyRef.get();
    }

    private DataBuffer stringBuffer(String value) {
        if(value!=null) {
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

            NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
            DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
            buffer.write(bytes);
            return buffer;
        }else{
            NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
            return  nettyDataBufferFactory.allocateBuffer(0);
        }

    }

    @Override
    public int getOrder() {
        return 10;

    }
}