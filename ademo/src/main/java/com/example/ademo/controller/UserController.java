package com.example.ademo.controller;

import com.example.ademo.controller.utils.Result;
import com.example.ademo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//        log.warn("test log->debug");
        session.setAttribute("userId", id);
        System.out.println(session.getAttribute("userId"));
//            currentUser = iUserService.getById(index);
//            System.out.println(currentUser);

        return new Result(true, iUserService.mySelectById(id));
    }

    @GetMapping("/logout")
    public Result logout(HttpSession session) {
//        log.warn("test log->debug");
        session.removeAttribute("userId");
        return new Result(true);
    }

    @GetMapping("/list")
    public Result retList() {
//        log.warn("test log->debug");
        return new Result(true, iUserService.myList());
    }


}
