package com.example.ademo.mapper;

import com.example.ademo.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println(articleMapper.myList());
    }

    @Test
    void myInsert() {
        Article article = new Article("current", "my first work", 2);
        articleMapper.myInsert(article);
        System.out.println(article.getArticleId());
    }

}
