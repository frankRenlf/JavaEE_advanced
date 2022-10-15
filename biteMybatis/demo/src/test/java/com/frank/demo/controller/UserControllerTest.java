package com.frank.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.controller
 * @createTime : 2022/10/8 14:24
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;
//    @Test
//    void getAll1() {
//        System.out.println(userController.getAll1());
//    }
//
//    @Test
//    void getAll2() {
//        System.out.println(userController.getAll2());
//    }

    @Test
    void getById() {
        System.out.println(userController.getById(2));
    }

//    @Test
//    void fastTest() {
//        userController.fastTest();
//    }
}
