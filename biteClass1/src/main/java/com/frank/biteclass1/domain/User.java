package com.frank.biteclass1.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.domain
 * @createTime : 2022/9/15 16:19
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    //    @TableField("createtime")
    private Date createTime;
    @TableField("updatetime")
    private Date updateTime;
    private Integer state;
    private List<Article> articleList;

    public User(String username, String password) {
        this.id = null;
        this.username = username;
        this.password = password;
    }

}
