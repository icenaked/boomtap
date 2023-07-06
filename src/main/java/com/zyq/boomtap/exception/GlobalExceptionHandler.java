package com.zyq.boomtap.exception;


import com.zyq.boomtap.model.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public ResultVO ex(Exception e){
        e.printStackTrace();
        return ResultVO.buildFailure("出现异常！");
    }
}
