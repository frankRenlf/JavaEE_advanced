package com.frank.demo.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.controller.utils
 * @createTime : 2022/11/9 20:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@RestControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Object exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", -1);
        result.put("data", null);
        result.put("message", "总的异常信息：" + e.getMessage());
        return result;
    }

}
