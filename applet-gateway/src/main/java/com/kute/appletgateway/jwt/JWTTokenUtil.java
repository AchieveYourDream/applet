package com.kute.appletgateway.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Name: JWT工具类
 * @Description: JWT工具类
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-21
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-21
 */
@Component
public class JWTTokenUtil implements Serializable {
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    /**
     * 从数据声明生成令牌
     * @param claims 数据声明
     * @return 令牌
     */
    public static String generateToken(String secret, String expiration, Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + Long.parseLong(expiration) * 1000);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    
    /**
     * 从令牌中获取数据声明
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims getClaimsFromToken(String secret, String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     * @param userDetails 用户
     * @return 令牌
     */
    public static String generateToken(String secret, String expiration, UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(secret, expiration, claims);
    }

    /**
     * 从令牌中获取用户名
     * @param token 令牌
     * @return 用户名
     */

    public static String getUsernameFromToken(String secret, String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(secret, token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    
    /**
     * 判断令牌是否过期
     * @param token 令牌
     * @return 是否过期
     */
    public static Boolean isTokenExpired(String secret, String token) {
        try {
            Claims claims = getClaimsFromToken(secret, token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
    
    /**
     * 刷新令牌
     * @param token 原令牌
     * @return 新令牌
     */
    public static String refreshToken(String secret, String expiration, String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(secret, token);
            claims.put("created", new Date());
            refreshedToken = generateToken(secret, expiration, claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }
    
    /**
     * 验证令牌
     * @param token       令牌
     * @param secret 用户
     * @return 是否有效
     */
    public static Boolean validateToken(String secret, String token) {
        try {
            return !isTokenExpired(secret, token);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否需要刷新令牌
     * @param token 令牌
     * @param secret 用户
     * @return 是否有效
     */
    public static Boolean isRefreshToken( String secret,String expiration, String token) {
        try {
          long timeoutDate=  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().getTime();;
          long newDate=new Date().getTime();
          //当过期时间小于当前时间的半个小时直接 并且大于0 返回ture
          //   (Integer.valueOf(expiration)*200) =token有效期 *0.2*1000
          if((timeoutDate-newDate)<(Integer.valueOf(expiration)*200) && (timeoutDate-newDate)>0){
              return  true;
          }else{
              return  false;
          }
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {

   String token  = generateToken("JWT_SECRET","3200", new JWTUserDetails( "wangbin"));
        System.out.println(token);


//      boolean s=  validateToken("JWT_SECRET","eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NTYzNTM2MTYsInN1YiI6IndhbmdiaW4iLCJjcmVhdGVkIjoxNTU2MzUyNjE2OTE4fQ.VW7avKg9wxeZcUuphNDLnv0mY2XZ-zci6vhilBAvPvAlul0rb9EONLjgMgy9g20xqQyR41GZspOyJB_dw_bvWw");
//        System.out.println(s);

       Date o=  Jwts.parser().setSigningKey("JWT_SECRET").parseClaimsJws(token).getBody().getExpiration();;


        System.out.println(o);
        System.out.println(o.getTime());

        System.out.println(new Date().getTime());
        System.out.println(o.getTime()-new Date().getTime() );


        System.out.println(  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1556521051)));

    }
}
