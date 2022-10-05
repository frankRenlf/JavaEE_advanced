package com.frank.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.demo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

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
public interface UserDao extends BaseMapper<UserInfo> {

    public List<UserInfo> getAll();

    public UserInfo getById(Integer id);

}
