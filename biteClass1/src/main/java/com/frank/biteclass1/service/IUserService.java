package com.frank.biteclass1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.biteclass1.domain.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.service
 * @createTime : 2022/9/16 10:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public interface IUserService extends IService<User> {
    Boolean check(User user);

    Boolean contain(User user);
}
