package com.frank.demo.dao;

import com.frank.demo.domain.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    void updateById() {
        System.out.println(userDao.updateById(1, "test"));
    }

    @Test
    @Transactional
    void deleteByIdInt() {
        System.out.println(userDao.deleteByIdInt(2));
    }

    @Test
    @Transactional
    void add() {
        UserInfo userInfo = new UserInfo(null, "testadd", "123", "photo2", null, null, null);

        System.out.println(userDao.add(userInfo));
        System.out.println(userInfo.getId());
    }

    @Test
    void selectBySub() {
        System.out.println(userDao.selectBySub("d"));
    }
}
