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
 * @createTime : 2022/9/29 16:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Controller
public class UserController {

//    @Autowired
    private UserService user;

    @Autowired
    public UserController(@Qualifier(value="userService2") UserService userService) {
        this.user = userService;
    }
//    @Autowired
//    @Qualifier("userInfo1")
//    public void setUser(UserService user) {
//        this.user = user;
//    }

    public void greet() {
        user.test();
    }
}
