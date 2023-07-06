package com.zyq.boomtap;

import com.zyq.boomtap.mapper.UserMapper;
import com.zyq.boomtap.model.po.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//springboot整合单元测试的注解
@SpringBootTest
class BoomtapApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userListTest(){
        List<User> list = userMapper.list();
        list.stream().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void womanListTest(){
        List<User> list = userMapper.womanList();
        list.stream().forEach(user -> {
            System.out.println(user);
        });
    }

    /**
     * 生成Jwt
     */
    @Test
    public void genJwtTest(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","zyq");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "zyqlsq") //签名算法
                .setClaims(claims) //自定义数据
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //令牌过期时间1h
                .compact(); //生成

        System.out.println(jwt);
    }

    @Test
    public void parseJwtTest(){
        Claims claims = Jwts.parser()
                .setSigningKey("zyqlsq")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoienlxIiwiaWQiOjEsImV4cCI6MTY4ODY0MjYwNn0.YTptz1gGpc3fu7Y4aHoLUVLSQlArObvT0U22xPlQxzU")
                .getBody();
        System.out.println(claims);
    }
}
