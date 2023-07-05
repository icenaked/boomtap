package com.zyq.boomtap;

import com.zyq.boomtap.mapper.UserMapper;
import com.zyq.boomtap.model.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

}
