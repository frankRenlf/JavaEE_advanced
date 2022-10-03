package com.frank.biteclass1.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.Controller
 * @createTime : 2022/10/3 17:35
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Slf4j
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/param10")
    public String param10(HttpServletResponse response, HttpServletRequest
            request) {
        String name = request.getParameter("name");
// 获取所有 cookie 信息
        Cookie[] cookies = request.getCookies();
        String userAgent = request.getHeader("User-Agent");
        return name + "：" + userAgent;
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue("bite") String bite) {
        return "cookie：" + bite;
    }

    @RequestMapping("/sess2")
    @ResponseBody
    public String sess2(@SessionAttribute(value = "username", required =
            false) String username) {
        return "username：" + username;
    }

    @RequestMapping("/setsess")
    @ResponseBody
    public String setsess(HttpServletRequest request) {
// 获取 HttpSession 对象，参数设置为 true 表示如果没有 session 对象就创建⼀个session
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.setAttribute("username", "java");
        }
        return "session 存储成功";
    }

}
