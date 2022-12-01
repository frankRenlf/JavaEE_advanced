package com.example.ademo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ademo.domain.Article;
import com.example.ademo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.service
 * @createTime : 2022/11/29 12:38
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public interface IUserService extends IService<User> {

    User mySelectById(Integer id);
    List<User> myList();
//    Integer myUpdate(Article article);

}
