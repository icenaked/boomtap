package com.zyq.boomtap.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//rest模式
@RestController
@RequestMapping("/start")
public class StartController {

    @GetMapping
    public String getById(){
        System.out.println("spring boot, 启动！");
        return "spring boot, 启动！";
    }
}
