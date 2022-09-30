package com.beans;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.beans
 * @createTime : 2022/9/30 17:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifeComponent implements BeanNameAware {
    @PostConstruct
    public void postConstruct() {
        System.out.println("执⾏ PostConstruct()");
    }

    public void init() {
        System.out.println("执⾏ BeanLifeComponent init-method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执⾏：preDestroy()");
    }


    public void use(String s) {
        System.out.println(s);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("执⾏了 setBeanName ⽅法：" + s);
    }
}
