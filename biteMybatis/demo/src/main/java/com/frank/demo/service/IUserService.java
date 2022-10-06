package com.frank.demo.service;

import com.frank.demo.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.service
 * @createTime : 2022/10/5 16:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public interface IUserService{

    public List<User> getAll();

    public User getById(Integer id);
}
