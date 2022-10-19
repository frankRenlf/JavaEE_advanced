package com.frank.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.demo.domain.Article;
import com.frank.demo.mapper.ArticleMapper;
import com.frank.demo.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.service.Impl
 * @createTime : 2022/10/19 18:25
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;




    @Override
    public List<Article> getAll() {

        return articleMapper.selectAll();

    }

    @Override
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }
}
