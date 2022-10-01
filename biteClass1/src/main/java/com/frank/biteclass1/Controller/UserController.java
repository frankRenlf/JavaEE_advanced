package com.frank.biteclass1.Controller;

import com.frank.biteclass1.Controller.utils.Result;
import com.frank.biteclass1.domain.User;
import com.frank.biteclass1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(iUserService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, iUserService.getById(id));
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return new Result(true, iUserService.check(user));
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (user.getUsername() != null && user.getPassword() != null
                && !user.getUsername().equals("") && !user.getPassword().equals("")
                && !iUserService.contain(user)) {
            return new Result(true, iUserService.save(user));
        }
        return new Result(true, false);
    }

//    @PostMapping
//    public Result save(@RequestBody User user) throws IOException {
////        return new Result(iUserService.save(user));
//        Boolean flag = iUserService.save(user);
//        return new Result(flag, user, flag ? "增加成功" : "增加失败");
//    }

}
