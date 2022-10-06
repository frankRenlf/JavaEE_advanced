package com.frank.demo.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.domain
 * @createTime : 2022/10/6 15:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("articleinfo")
public class Article {
    private Integer id;
    private String title;
    private String content;
    //    @TableField("createtime")
    private LocalDateTime createtime;
    //    @TableField("updatetime")
    private LocalDateTime updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
    private User user;
}
