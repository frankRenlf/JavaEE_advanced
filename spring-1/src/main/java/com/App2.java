package com;

import com.beans.User;
import com.beans.UserController;
import com.beans.UserController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Introspector;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com
 * @createTime : 2022/9/30 9:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class App2 {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserController2 user = context.getBean(UserController2.class);
        user.getUser1().setName("frank");

        System.out.println(user.getUser1());
        System.out.println(user.getUser2());

    }

}
