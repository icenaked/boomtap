package com.zyq.boomtap.controller;

import com.zyq.boomtap.model.vo.UserVO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//RestController包括Controller和ResponseBody
@RestController
@RequestMapping("/study")
public class StudyController {

    //普通servlet传参
    @GetMapping("/servletRequest")
    public String simpleParam(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int ageInt = Integer.parseInt(age);
        return "name: "+name+" age: "+ageInt;
    }

    //springboot传参
    @GetMapping("/springbootRequest")
    public String springbootParam(String name, Integer age){
        return "name: "+name+" age: "+age;
    }

   //传参数变成vo类
    @PostMapping("/simplePOJO")
    public String simplePOJO(UserVO userVO){
        String info = userVO.toString();
        return "OK "+info;
    }

    //传数组参数
    @GetMapping("/array")
    public String arrayParam(String[] hobby){
        return Arrays.toString(hobby);
    }

    //传数组集合参数
    @GetMapping("/list")
    //因为多个传入值会被认为是数组，加@RequestParam才会被认为是一个东西
    public List<String> listParam(@RequestParam List<String> hobby){
        return hobby;
    }

    //传日期
    @GetMapping("/date")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime time){
        return time.toString();
    }

    //传json,必须要post+body
    @PostMapping("/json")
    public String JSONParam(@RequestBody UserVO userVO){
        return userVO.toString();
    }

    //路径参数
    @GetMapping("/{id}")
    public Integer path(@PathVariable Integer id){
        return id;
    }


}
