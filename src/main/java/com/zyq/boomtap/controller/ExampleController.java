package com.zyq.boomtap.controller;

import com.zyq.boomtap.service.ExampleService;
import com.zyq.boomtap.serviceImpl.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    // 耦合了,不合适
    private ExampleService exampleServiceNotGood= new ExampleServiceImpl();

    // 将对象放在容器中，要用的时候复制过来（IOC控制反转）
    // 从应用程序控制对象的创建反转为容器来控制（IOC容器/spring容器），被控制的对象叫bean
    // 容器为应用程序提供运行时需要的资源，DI（依赖注入）
    @Autowired//依赖注入
    private ExampleService exampleService;  //private也可以省略，默认的就是private

}
