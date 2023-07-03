package com.zyq.boomtap.model.vo;

public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultVO<T> buildSuccess(){
        return new ResultVO<T>(1, "success", null);
    }

    public static <T> ResultVO<T> buildSuccess(T data){
        return new ResultVO<T>(1, "success", data);
    }

    public static <T> ResultVO<T> buildFailure(String errMsg){
        return new ResultVO<T>(0, "fail: "+errMsg, null);
    }
}
