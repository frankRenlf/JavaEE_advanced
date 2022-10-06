package com.frank.demo.mapper;

import com.frank.demo.domain.User;
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
 * @Package : com.frank.demo.mapper
 * @createTime : 2022/10/6 19:54
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void getUserById() {


    }

    @Test
    void getTest() {
        User user = new User(2, "a", "123", "photo2", null, null, null,null);
        System.out.println(userMapper.getTest(user));
    }

    @Test
    void getTrim() {
        User user = new User(1, "t", "2", "photo2", null, null, null,null);
        System.out.println(userMapper.testTrim(user));
    }
}
