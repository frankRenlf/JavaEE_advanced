package com.frank.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.demo.dao.UserDao;
import com.frank.demo.domain.UserInfo;
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
public class UserServiceImpl extends ServiceImpl<UserDao, UserInfo> implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserInfo> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserInfo getById(Integer id) {
        return userDao.getById(id);
    }
}
