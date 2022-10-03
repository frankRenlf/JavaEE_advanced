package com.frank.biteclass1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.biteclass1.domain.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.dao
 * @createTime : 2022/10/3 16:30
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
}
