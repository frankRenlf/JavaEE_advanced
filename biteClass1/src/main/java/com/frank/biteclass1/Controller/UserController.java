package com.frank.biteclass1.Controller;

import com.frank.biteclass1.Controller.utils.Result;
import com.frank.biteclass1.domain.User;
import com.frank.biteclass1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private IUserService iUserService;

    @GetMapping
    public Result getById(@RequestBody User user) {
        return new Result(true, iUserService.check(user));
    }

    @PostMapping
    public Result save(@RequestBody User user) {
        return new Result(iUserService.save(user));
    }

    @PostMapping("/del")
    public Result addUser(@RequestBody User user) {
        return new Result(iUserService.removeById(user.getId()));
    }

}
