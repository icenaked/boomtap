package com.zyq.boomtap;

import com.zyq.boomtap.controller.StartController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//开启对servlet组件的支持，本项目用于支持filter
@ServletComponentScan
public class BoomtapApplication {

    public static void main(String[] args) {
        //启动一个spring容器，我们定义的bean可以加载到它里面（只能扫描到com.zyq.boomtap里面的）
        ConfigurableApplicationContext ctx = SpringApplication.run(BoomtapApplication.class, args);
        StartController bean = ctx.getBean(StartController.class);
        System.out.println("启动类也是一个bean====>"+bean);
    }

}
