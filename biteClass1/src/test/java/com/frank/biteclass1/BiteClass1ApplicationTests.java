package com.frank.biteclass1;

import com.frank.biteclass1.domain.Article;
import com.frank.biteclass1.domain.User;
import com.frank.biteclass1.service.IArticleService;
import com.frank.biteclass1.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class BiteClass1ApplicationTests {
    @Autowired
    IUserService iUserService;
    @Autowired
    IArticleService iArticleService;

    @Test
    void contextLoads() {
        System.out.println(iUserService.check(new User("frank1", "666")));
    }

    @Test
    void checkContain() {
        System.out.println(iUserService.contain(new User("frank1", "666")));
    }

    @Test
    void checkSave() {
        System.out.println(iUserService.save(new User("frank", "666")));
    }

    @Test
    void checkArticleSave() {


        System.out.println();
    }
}
