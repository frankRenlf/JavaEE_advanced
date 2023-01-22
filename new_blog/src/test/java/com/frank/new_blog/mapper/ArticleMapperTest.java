package com.frank.new_blog.mapper;

import com.frank.new_blog.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    void myInsert() {
        Article article = new Article("now", "day's first work", 1);
        articleMapper.myInsert(article);
        System.out.println(article.getArticleId());
    }

    @Test
    void myRemoveById() {
        System.out.println(articleMapper.myRemoveById(19));
    }

    @Test
    void myUpdate() {
        System.out.println(articleMapper.myUpdate(new Article(5, "change2", "what's up 2")));
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
        article.setTitle("e");
        Date s = new Date("Thu Oct 05 16:43:50 CST 2022");
        Date e = new Date("Thu Oct 22 16:43:51 CST 2022");
        article.setCreateTime(s);
        article.setUpdateTime(e);
        System.out.println(articleMapper.mySelectByParams(article));
    }

    @Test
    void myDeleteListId() {
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(18);
        System.out.println(articleMapper.myDeleteListId(list));
    }

    @Test
    void listAll() {
        System.out.println(articleMapper.listAll("asc"));
    }

    @Test
    void testMyList() {
        System.out.println(articleMapper.myList("desc", 0));
    }

    @Test
    void countByUserid() {
        System.out.println(articleMapper.countByUserid(1));
    }

    @Test
    void addRcount() {
        System.out.println(articleMapper.addRcount(1, 1));
    }

    @Test
    void pagingList() {
        System.out.println(articleMapper.pagingList("desc", 2, 2));
    }
}
