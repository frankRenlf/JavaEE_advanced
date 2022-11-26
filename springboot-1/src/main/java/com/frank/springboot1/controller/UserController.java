package com.frank.springboot1.controller;

import com.frank.springboot1.controller.utils.Result;
import com.frank.springboot1.domain.User;
import com.frank.springboot1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : springboot-1
 * @Package : com.frank.springboot1.controller
 * @createTime : 2022/11/19 14:44
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

    @Value("${mybatis-plus.mapper-locations}")
    private String config;

    @PostConstruct
    public void postConstruct() {
        System.out.println(config);
    }

    @GetMapping("/{id}")
    public Result retUser(@PathVariable Integer id) {
        log.warn("test log->debug");
        return new Result(true, iUserService.selectById(id));
    }

    @GetMapping("/list")
    public Result retUserList() {
        return new Result(true, iUserService.list());
    }

    @GetMapping("/login1")
    public Result testServlet(User user2) {
        return new Result(true, user2, "success");
    }

    @PostMapping("/login2")
    public Result testLogin2(@RequestBody User user) {
        return new Result(true, user, "success");
    }

    @PostMapping("/file")
    public String param9(String name, @RequestPart("myfile") MultipartFile file) throws IOException {
        // 获取⽂件后缀名
        String fileName = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        // ⽂件保存地址
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() +
                "/" + UUID.randomUUID() + fileName;
        // 保存⽂件
        file.transferTo(new File(filePath));
        return filePath + " 上传成功.";
    }

}
