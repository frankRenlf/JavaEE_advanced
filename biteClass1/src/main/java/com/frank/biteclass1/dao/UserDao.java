package com.frank.biteclass1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.biteclass1.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.dao
 * @createTime : 2022/9/16 10:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from userinfo where username = #{username}")
    public User selectByName(String username);
}
