package com.frank.biteclass1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.biteclass1.dao.UserDao;
import com.frank.biteclass1.domain.User;
import com.frank.biteclass1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.service.impl
 * @createTime : 2022/9/16 10:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    private UserDao userDao;


    @Override
    public Boolean check(User user) {
        log.trace("call check method");
        User pre = userDao.selectByName(user.getUsername());
        return pre != null
                && pre.getUsername().equals(user.getUsername())
                && pre.getPassword().equals(user.getPassword());
    }

    @Override
    public Boolean contain(User user) {
        User pre = userDao.selectByName(user.getUsername());
        return pre != null
                && pre.getUsername().equals(user.getUsername());
    }
}
