package com.beans;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.beans
 * @createTime : 2022/9/29 23:29
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Service
public class UserService {

    private int id;
    private String name;

    public UserService() {
    }

    public UserService(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "UserService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void test() {
        System.out.println("test: " + this);
    }

}
