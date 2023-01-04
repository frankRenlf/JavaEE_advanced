package com.example.ademo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ademo.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.mapper
 * @createTime : 2022/12/1 20:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    Article mySelectById(Integer id);

    List<Article> myList(String order);

    Integer myInsert(Article article);

    Integer myRemoveById(Integer id);

    Integer myUpdate(Article article);

    List<Article> myFindByTitle(String sub);

    Article mySelectByIdUser(Integer id);

    List<Article> mySelectByParams(Article article);

    Integer myDeleteListId(List<Integer> listId);

}
