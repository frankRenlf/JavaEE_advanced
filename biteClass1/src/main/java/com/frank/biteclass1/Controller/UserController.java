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

    @GetMapping
    public Result getById(@RequestBody User user) {
        return new Result(true, iUserService.check(user));
    }

    @PostMapping
    public Result save(@RequestBody User user) throws IOException {
//        return new Result(iUserService.save(user));
        User[] list = iUserService.list().toArray(new User[0]);
        for (User elem : list) {
            if (elem.getUsername().equals(user.getUsername())) {
                return new Result(false, user, "已经存在该用户名");
            }
        }
        Boolean flag = iUserService.save(user);
        return new Result(flag, user, flag ? "增加成功" : "增加失败");
    }

    @PostMapping("/del")
    public Result addUser(@RequestBody User user) {
        User[] list = iUserService.list().toArray(new User[0]);
        for (User elem : list) {
            if (elem.getUsername().equals(user.getUsername())) {
                user.setId(elem.getId());
            }
        }
        return new Result(iUserService.removeById(user.getId()), user, "删除成功");
    }

}
