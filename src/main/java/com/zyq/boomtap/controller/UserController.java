package com.zyq.boomtap.controller;


import com.zyq.boomtap.model.vo.ResultVO;
import com.zyq.boomtap.model.vo.UserVO;
import com.zyq.boomtap.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Slf4j用来记录日志
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO<UserVO> login(@RequestBody UserVO userVO){
        UserVO userVO2 = userService.login(userVO);
        return userVO2!=null?ResultVO.buildSuccess():ResultVO.buildFailure("用户名或密码错误！");
    }
}
