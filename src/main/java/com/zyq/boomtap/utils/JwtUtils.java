package com.zyq.boomtap.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static String signKey = "zyqlsq";

    private static Long expire = 43200000L;

    /**
     * 生成令牌
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey) //签名算法
                .setClaims(claims) //自定义数据
                .setExpiration(new Date(System.currentTimeMillis() + expire)) //令牌过期时间1h
                .compact(); //生成

       return jwt;
    }

    /**
     * 解析令牌
     */
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
