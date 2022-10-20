package com.frank.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.demo.domain.Article;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.service
 * @createTime : 2022/10/19 18:20
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public interface IArticleService extends IService<Article> {
    public Integer count(Integer id);

    public List<Article> getAll();

    public Article selectById2(Integer id);
}
