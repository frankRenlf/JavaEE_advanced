package com.frank.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.demo.mapper.UserMapper;
import com.frank.demo.domain.User;
import com.frank.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.service.Impl
 * @createTime : 2022/10/5 16:24
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById1(id);
    }
    @Override
    public Integer check(User user) {
        log.trace("call check method");
        User pre = userDao.selectByName(user.getUsername());
        Integer id = -1;
        if (pre != null
                && pre.getUsername().equals(user.getUsername())
                && pre.getPassword().equals(user.getPassword())) {
            id = pre.getId();
        }
        return id;
    }


    @Override
    public Boolean contain(User user) {
        User pre = userDao.selectByName(user.getUsername());
        return pre != null
                && pre.getUsername().equals(user.getUsername());
    }

    @Override
    public int addUser(User user) {
        return userDao.add(user);
    }
}
