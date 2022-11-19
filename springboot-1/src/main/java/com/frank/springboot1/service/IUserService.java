package com.frank.springboot1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.springboot1.domain.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : springboot-1
 * @Package : com.frank.springboot1.service
 * @createTime : 2022/11/19 14:41
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public interface IUserService extends IService<User> {

    User selectById(Integer id);

}
