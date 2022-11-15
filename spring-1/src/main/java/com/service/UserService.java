package com.service;

import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.service
 * @createTime : 2022/11/5 17:58
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Service
public class UserService {
    @Autowired
    @Qualifier(value = "user2")
    private User user2;

    @Autowired
    @Qualifier(value = "user2")
    private User user1;
//    public UserService(Object user2) {
//        this.user2 = user2;
//    }

    public void testUser() {
        user1.id = 3;
        System.out.println(user2.id + " " + user1.id);
    }

}
