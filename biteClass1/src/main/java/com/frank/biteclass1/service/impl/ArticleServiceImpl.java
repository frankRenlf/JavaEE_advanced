package com.frank.biteclass1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.biteclass1.dao.ArticleDao;
import com.frank.biteclass1.domain.Article;
import com.frank.biteclass1.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.service.impl
 * @createTime : 2022/10/3 14:12
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements IArticleService {
    @Autowired
    private ArticleDao articleDao;

}
