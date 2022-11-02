package com.frank.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : demo1
 * @Package : com.frank.demo1
 * @createTime : 2022/11/2 15:59
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@RestController
@RequestMapping("/say")
public class testcontroller {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

}
