package com.frank.demo.mapper;

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
public interface ArticleMapper extends BaseMapper<Article> {
//    @Select("select ai.*, ui.*\n" +
//            "from (articleinfo ai inner join userinfo ui on ai.uid = ui.id)\n" +
//            "where ai.id = id")
    public Article selectById2(@Param("id") Integer id);
    @Select("select count(ai.id) cnt\n" +
            "from articleinfo ai\n" +
            "         inner join userinfo ui\n" +
            "                    on ai.uid = ui.id\n" +
            "where ui.id = #{id}")
    public Integer count(Integer id);

    @Select("select ai.*,ui.* from articleinfo ai inner join userinfo ui where ai.uid = ui.id")
    public List<Article> selectAll();


}
