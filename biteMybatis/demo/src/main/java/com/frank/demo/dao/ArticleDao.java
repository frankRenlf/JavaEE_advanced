package com.frank.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.demo.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.dao
 * @createTime : 2022/10/6 16:31
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Select("select ai.*,ui.* from articleinfo ai inner join userinfo ui where ai.uid = ui.id")
    public List<Article> selectById(Integer id);
}
