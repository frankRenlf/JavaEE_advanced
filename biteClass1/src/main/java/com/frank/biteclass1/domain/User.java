package com.frank.biteclass1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.domain
 * @createTime : 2022/9/15 16:19
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.id = null;
        this.username = username;
        this.password = password;
    }
}
