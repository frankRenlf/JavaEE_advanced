package com.frank.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.dao
 * @createTime : 2022/10/6 16:33
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@SpringBootTest
class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;
    @Test
    void selectById() {
        System.out.println(articleDao.selectById(1));
    }
}
