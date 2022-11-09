package com.frank.demo.controller;

import com.frank.demo.controller.utils.Result;
import com.frank.demo.domain.User;
import com.frank.demo.service.IArticleService;
import com.frank.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private IArticleService iArticleService;


//    public static User currentUser = new User();

    @GetMapping("/testAdvice/{id}")
    public Result testAdvice(@PathVariable Integer id) {
        int ret = id/0;
        return new Result(true);
    }


    @GetMapping("{id}")
    public Result getUserByArticleId(@PathVariable Integer id) {
        Integer userId = iUserService.selectByArticleId(id);
        User user = iUserService.getById(userId);
        user.setPassword(iArticleService.count(userId).toString());
        return new Result(true, user);
    }

    @GetMapping
    public Result getById(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("userid");
        User user = iUserService.getById(id);
        user.setPassword(iArticleService.count(user.getId()).toString());
        return new Result(true, user);
    }


    @GetMapping("/check")
    public Result checkLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Integer index = 0;
        if (session == null) {
            response.setStatus(403);
        } else {
            index = (Integer) session.getAttribute("userid");
            if (index == null) {
                response.setStatus(403);
            }
        }
        return new Result(true, index);
    }

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.removeAttribute("userid");
        return new Result(true);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        Integer index = iUserService.check(user);
        System.out.println("----------------");
        System.out.println(index);
        HttpSession session = request.getSession(true);
        if (index > 0) {
            session.setAttribute("userid", index);
            System.out.println(session.getAttribute("userid"));
//            currentUser = iUserService.getById(index);
//            System.out.println(currentUser);
        } else {
            response.setStatus(403);
        }
        return new Result(true, index > 0);
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (user.getUsername() != null && user.getPassword() != null
                && !user.getUsername().equals("") && !user.getPassword().equals("")
                && !iUserService.contain(user)) {
            log.info(user.getUsername() + " register success");
            System.out.println("----------");
            int val = iUserService.addUser(user);
            System.out.println(val);
            return new Result(true, val);
        }
        log.info(user.getUsername() + " register failed");
        return new Result(true, false);
    }

    /**
     * test log
     */
    @GetMapping("/testLogging")
    public void testLogin() {
        System.out.println("-------------------");
        log.trace("trace");
        log.warn("warn");
        System.out.println("-------------------");
    }

//    @PostMapping
//    public Result save(@RequestBody User user) throws IOException {
////        return new Result(iUserService.save(user));
//        Boolean flag = iUserService.save(user);
//        return new Result(flag, user, flag ? "增加成功" : "增加失败");
//    }

}

