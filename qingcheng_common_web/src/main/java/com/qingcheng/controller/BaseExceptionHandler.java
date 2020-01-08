package com.qingcheng.controller;

import com.qingcheng.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author QiuMingJie
 * @date 2020-01-07 20:49
 * @Description
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * 检测的异常类型
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        System.out.println("调用了异常处理");
        return new Result(-1, "失败"+e.getMessage());
    }
}
