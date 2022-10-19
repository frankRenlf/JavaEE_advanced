package com.frank.demo.aop;

import com.frank.demo.controller.UserController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    HttpSession session = UserController.session;

    @Pointcut(value = "execution(* com.frank.demo.controller.UserController.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore() {
//        session.getAttribute("userid");
        System.out.println("执⾏ Before ⽅法");
    }

    // 后置通知
    @After("pointcut()")
    public void doAfter() {
        System.out.println("执⾏ After ⽅法");
    }

    // return 之前通知
    @AfterReturning("pointcut()")
    public void doAfterReturning() {
        System.out.println("执⾏ AfterReturning ⽅法");
    }

    // 抛出异常之前通知
    @AfterThrowing("pointcut()")
    public void doAfterThrowing() {
        System.out.println("执⾏ doAfterThrowing ⽅法");
    }

    // 添加环绕通知
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        Object obj = null;
        System.out.println("Around ⽅法开始执⾏");
        try {
            stopWatch.start();
            // 执⾏拦截⽅法
            obj = joinPoint.proceed();
            stopWatch.stop();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Around ⽅法结束执⾏");
        System.out.println(joinPoint.getSignature().getName() + " time consumption: " + stopWatch.getTotalTimeMillis() + "ms");
        return obj;
    }
}

