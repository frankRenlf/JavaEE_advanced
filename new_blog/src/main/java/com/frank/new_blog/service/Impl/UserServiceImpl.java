package com.frank.new_blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.new_blog.domain.User;
import com.frank.new_blog.mapper.UserMapper;
import com.frank.new_blog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.service.Impl
 * @createTime : 2022/11/29 12:39
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User mySelectById(Integer id) {
        return userMapper.mySelectById(id);
    }

    @Override
    public List<User> myList() {
        return userMapper.myList();
    }

    @Override
    public Integer myInsert(User user) {
        return userMapper.myInsert(user);
    }

    @Override
    public User mySelectByName(String username) {
        return userMapper.mySelectByName(username);
    }

    @Override
    public Integer checkIdentity(User user) {
        return userMapper.checkIdentity(user);
    }
}
