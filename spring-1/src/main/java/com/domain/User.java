package com.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/11/3 17:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Component
public class User {

    public Integer id;

    public User() {
        this.id = 1;
    }

    public User(Integer id) {
        this.id = id;
    }

    @Bean(name = {"user1"})
    public User user11() {
        return new User(1);
    }

    @Bean
    public User user2() {
        return new User(2);
    }
}
