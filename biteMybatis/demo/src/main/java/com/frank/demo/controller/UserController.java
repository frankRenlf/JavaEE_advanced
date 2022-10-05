package com.frank.demo.controller;

import com.frank.demo.controller.utils.Result;
import com.frank.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.controller
 * @createTime : 2022/10/5 16:30
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/fir")
    public Result getAll1() {
        return new Result(true, iUserService.getAll());
    }

    @GetMapping("/sec")
    public Result getAll2() {
        return new Result(true, iUserService.list());
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable String id) {
        return new Result(true, iUserService.getById(id));
    }

}
