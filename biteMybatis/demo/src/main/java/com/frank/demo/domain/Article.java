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

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    @TableField("createtime")
    private LocalDateTime createTime;
    @TableField("updatetime")
    private LocalDateTime updateTime;
    private Integer rcount;
    private User user;
}
