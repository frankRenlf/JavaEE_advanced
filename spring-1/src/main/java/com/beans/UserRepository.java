package com.beans;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.beans
 * @createTime : 2022/9/29 23:31
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Repository
public class UserRepository {

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = {"user1"})
    public User getUser1() {
        User user1 = new User(1, "f");
//        System.out.println(user1);
        return user1;
    }
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = {"user2"})
    public User getUser2() {
        return new User(2, "a");
    }

}
