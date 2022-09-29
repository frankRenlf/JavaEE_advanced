package com.beans;

import org.springframework.context.annotation.Bean;
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
    public UserController() {
        System.out.println(Bean.class);
    }

    public void greet(String name) {

        System.out.println("Hi " + name);
    }
}
