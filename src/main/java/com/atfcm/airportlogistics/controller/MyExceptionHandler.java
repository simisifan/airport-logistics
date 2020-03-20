package com.atfcm.airportlogistics.controller;

import com.atfcm.airportlogistics.common.Myexception.MyNullException;
import com.atfcm.airportlogistics.common.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MyNullException.class)
    public ResultInfo resultInfo(Exception e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setFlag(false);
        resultInfo.setErrorMsg("验证码不能为空");
        return  resultInfo;

    }


}
