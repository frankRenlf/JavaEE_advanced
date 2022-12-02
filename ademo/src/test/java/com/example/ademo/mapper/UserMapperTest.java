package com.example.ademo.mapper;

import com.example.ademo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println(userMapper.mySelectByIdArticles(2));
    }
}
