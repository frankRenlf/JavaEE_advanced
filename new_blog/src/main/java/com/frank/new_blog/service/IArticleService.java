package com.frank.new_blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.new_blog.domain.Article;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.service
 * @createTime : 2022/12/1 20:09
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public interface IArticleService extends IService<Article> {
    Article mySelectById(Integer id);
    List<Article> myList(String order,Integer uid);
    List<Article> listAll(String order);
    List<Article> pagingList(String order, Integer limit, Integer offset);
    Integer countList();
    Integer countByUserId(Integer uid);
    Integer myInsert(Article article);
    Integer myRemoveById(Integer id);
    Integer myUpdate(Article article);
    void addRcount(Integer id, Integer rcount);
}
