package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.beans
 * @createTime : 2022/9/29 23:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Component
public class UserComponent {

    private int id;

    public UserComponent() {
    }

    public UserComponent(int id) {
        this.id = id;
    }



    @Bean(name = {"userInfo", "userInfo1"})
    public User getUser1() {
        return new User(1, "frank");
    }

    @Bean(name = {"userInfo2"})
    public User getUser2() {
        return new User(2, "lily");
    }

}
