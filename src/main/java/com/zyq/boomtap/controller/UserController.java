package com.zyq.boomtap.controller;


import com.zyq.boomtap.model.vo.ResultVO;
import com.zyq.boomtap.model.vo.UserVO;
import com.zyq.boomtap.service.UserService;
import com.zyq.boomtap.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//Slf4j用来记录日志
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserVO userVO){
        UserVO u = userService.login(userVO);

        if (u!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("username",u.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return ResultVO.buildSuccess(jwt);
        }

        return ResultVO.buildFailure("用户名或密码错误！");

    }
}
