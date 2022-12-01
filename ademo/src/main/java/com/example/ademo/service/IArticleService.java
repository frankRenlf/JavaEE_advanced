package com.example.ademo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ademo.domain.Article;
import com.example.ademo.domain.User;

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
    List<Article> myList();
    Integer myInsert(Article article);
}
