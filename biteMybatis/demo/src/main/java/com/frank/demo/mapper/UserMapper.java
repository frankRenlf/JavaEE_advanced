package com.frank.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.demo.domain.User;
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
 * @Package : com.frank.demo.Dao
 * @createTime : 2022/10/5 16:21
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from userinfo where username = #{username}")
    public User selectByName(String username);

    @Select("select ui.id from articleinfo ai inner join userinfo ui on ai.uid = ui.id where ai.id = #{id}")
    public Integer selectByArticleId(Integer id);

    User user = new User();

    public List<User> getAll();

    public User getById1(Integer id);

    public int updateById(@Param("userid") Integer id, @Param("username") String name);

    public int deleteByIdInt(@Param("userid") Integer id);

    public int add(@Param("user") User userInfo);

    public List<User> selectBySub(@Param("username") String name, @Param("sort") String sort);

    public List<User> selectJoin(Integer id);

    User getUserById(Integer id);

    List<User> getAllUser();

    List<User> getTest(User user);

    List<User> testTrim(User user);

    List<User> testWhere(User user);

    Integer testSet(User user);

    List<User> testForeach(List<Integer> list);
}
