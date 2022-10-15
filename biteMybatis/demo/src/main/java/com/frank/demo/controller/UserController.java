package com.frank.demo.controller;

import com.frank.demo.controller.utils.Result;
import com.frank.demo.domain.User;
import com.frank.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(iUserService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, iUserService.getById(id));
    }

    @GetMapping
    public Result getByIdTest(@RequestParam(value = "userid", required = false) Integer id) {
        return new Result(true, iUserService.getById(id));
    }

    public static HttpSession session;
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        Integer index = iUserService.check(user);
        session = request.getSession(true );
        if (index>0) {
            session.setAttribute("userid", index);
            System.out.println(session.getAttribute("userid"));
        }
        return new Result(true, index>0);
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (user.getUsername() != null && user.getPassword() != null
                && !user.getUsername().equals("") && !user.getPassword().equals("")
                && !iUserService.contain(user)) {
            log.info(user.getUsername() + " register success");
            return new Result(true, iUserService.addUser(user));
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

