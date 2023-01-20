package com.frank.new_blog.controller;

import com.frank.new_blog.utils.Constant;
import com.frank.new_blog.utils.Result;
import com.frank.new_blog.domain.User;
import com.frank.new_blog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.controller
 * @createTime : 2022/11/29 12:41
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/{id}")
    public Result retUser(@PathVariable Integer id, HttpSession session) {
        session.setAttribute(Constant.SESSION_USERID_KEY, id);
        System.out.println(session.getAttribute(Constant.SESSION_USERID_KEY));
        return new Result(true, iUserService.mySelectById(id));
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        Integer id = null;
        if (user != null) {
            id = iUserService.checkIdentity(user);
        }
        if (id != null) {
            session.setAttribute(Constant.SESSION_USERID_KEY, id);
            System.out.println(session.getAttribute(Constant.SESSION_USERID_KEY));
            return Result.success(id);
        }
        return Result.fail(id);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        Integer id = null;
        if (iUserService.mySelectByName(user.getUsername()) == null) {
            id = iUserService.myInsert(user);
            return Result.success(id);
        }
        return Result.fail(id);
    }

    @GetMapping("/logout")
    public Result logout(HttpSession session) {
//        log.warn("test log->debug");
        session.removeAttribute(Constant.SESSION_USERID_KEY);
        return new Result(true);
    }

    @GetMapping("/list")
    public Result retList() {
        log.warn("test log->debug");
        return new Result(true, iUserService.myList());
    }

    @GetMapping("/verify")
    public Result verify(HttpSession session) {
        return new Result(true, session.getAttribute(Constant.SESSION_USERID_KEY) != null);
    }

}
