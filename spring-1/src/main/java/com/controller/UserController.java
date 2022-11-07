package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.controller
 * @createTime : 2022/11/7 17:32
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Controller
public class UserController {

    private User user;

    public void testUser() {
        System.out.println(user.id);
    }

}
