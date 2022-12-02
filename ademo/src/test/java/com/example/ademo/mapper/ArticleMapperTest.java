package com.example.ademo.mapper;

import com.example.ademo.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.mapper
 * @createTime : 2022/12/1 20:07
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void mySelectById() {
        System.out.println(articleMapper.mySelectById(2));
    }

    @Test
    void myList() {
        System.out.println(articleMapper.myList("desc"));
    }

    @Test
    void myInsert() {
        Article article = new Article("current", "my first work", 2);
        articleMapper.myInsert(article);
        System.out.println(article.getArticleId());
    }

    @Test
    void myRemoveById() {
        System.out.println(articleMapper.myRemoveById(19));
    }

    @Test
    void myUpdate() {
        System.out.println(articleMapper.myUpdate(new Article(18,"change2", "what's up 2")));
    }

    @Test
    void myFindByTitle() {
        System.out.println(articleMapper.myFindByTitle("4"));
    }

    @Test
    void mySelectByIdUser() {
        System.out.println(articleMapper.mySelectByIdUser(2));
    }

    @Test
    void mySelectByParams() {
        Article article = new Article();
        article.setTitle("c");
        article.setCreateTime(Date.valueOf("2022-10-22"));
        article.setUpdateTime(Date.valueOf("2022-12-1"));
        System.out.println(articleMapper.mySelectByParams(article));
    }
}
