package com.frank.new_blog.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.controller.utils
 * @createTime : 2023/1/7 15:59
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
        result.put("message", "error_info " + e.getMessage());
        return result;
    }

}
