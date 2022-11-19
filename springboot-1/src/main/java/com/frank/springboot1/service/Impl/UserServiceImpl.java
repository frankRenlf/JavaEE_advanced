package com.frank.springboot1.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.springboot1.mapper.UserMapper;
import com.frank.springboot1.domain.User;
import com.frank.springboot1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : springboot-1
 * @Package : com.frank.springboot1.service.Impl
 * @createTime : 2022/11/19 14:42
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
    public User selectById(Integer id) {
        return userMapper.mySelectById(id);
    }
}
