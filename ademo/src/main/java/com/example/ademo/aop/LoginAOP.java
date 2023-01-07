package com.example.ademo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.aop
 * @createTime : 2023/1/7 12:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Component
@Aspect
public class LoginAOP {
    @Pointcut("execution(* com.example.ademo.controller.UserController.retUser(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("---------before---------");
    }
}
