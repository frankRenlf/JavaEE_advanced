package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.beans
 * @createTime : 2022/9/30 16:18
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Controller
public class UserController2 {

    @Autowired
    @Qualifier(value = "user1")
    private User user1;

    public User getUser1() {
        return user1;
    }

    @Autowired
    @Qualifier(value = "user1")
    private User user2;

    public User getUser2() {
        return user2;
    }

}
