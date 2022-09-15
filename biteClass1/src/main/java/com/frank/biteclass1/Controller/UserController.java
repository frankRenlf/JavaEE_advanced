package com.frank.biteclass1.Controller;

import com.frank.biteclass1.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.Controller
 * @createTime : 2022/9/15 18:49
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/add")
    public User add(Integer id, String name, String password) {
        return new User(id, name, password);
    }

    @RequestMapping("/delete")
    public Integer del(Integer id) {
        return id;
    }

    @RequestMapping("/getone")
    public HashMap<String, Object> getOne(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "frank");
        map.put("password", "1234");
        return map;
    }
}
