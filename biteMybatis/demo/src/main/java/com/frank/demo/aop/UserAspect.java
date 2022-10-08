package com.frank.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.aop
 * @createTime : 2022/10/8 11:30
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Aspect
@Component
public class UserAspect {

    @Pointcut(value = "execution(* com.frank.demo.controller.UserController.*(..))")
    public void pointcut() {
    }



}
