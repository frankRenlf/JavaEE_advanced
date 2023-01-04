package com.example.ademo.mapper;

import com.example.ademo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.mapper
 * @createTime : 2022/11/29 12:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.mySelectById(2));
    }

    @Test
    void myList() {
        System.out.println(userMapper.myList());
    }

    @Test
    void verify() {
        System.out.println(userMapper.verify(new User("frank","123")));
    }

    @Test
    void mySelectByIdArticles() {
        System.out.println(userMapper.mySelectByIdArticles(1));
    }

    @Test
    void mySelectByParams() {
        User user=new User();
        user.setUsername("t");
        Date s = new Date("Thu Oct 06 16:43:50 CST 2022");
        Date e = new Date("Thu Oct 15 16:43:51 CST 2022");
        user.setCreateTime(s);
        user.setUpdateTime(e);
        System.out.println(userMapper.mySelectByParams(user));
    }
}
