package com.frank.demo.dao;

import org.junit.jupiter.api.Assertions;
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
 * @Package : com.frank.demo.dao
 * @createTime : 2022/10/5 21:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void getAll() {
        System.out.println(userDao.getAll());
    }

    @Test
    void getById() {
        Assertions.assertNotNull(userDao.getById(2));
    }

    @Test
    void updateById() {
        System.out.println(userDao.updateById(1,"frank"));
    }
}
