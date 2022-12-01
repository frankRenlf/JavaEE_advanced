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


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("articleinfo")
public class Article {
    private Integer id;
    private String title;
    private String content;
    //    @TableField("createtime")
    private String createtime;
    //    @TableField("updatetime")
    private String updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
    private User user;

    public Article(Integer id, String title, String content, Timestamp createtime, Timestamp updatetime, Integer uid, Integer rcount, Integer state, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        if (createtime != null && updatetime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.createtime = simpleDateFormat.format(createtime);
            this.updatetime = simpleDateFormat.format(updatetime);
        }
        this.uid = uid;
        this.rcount = rcount;
        this.state = state;
        this.user = user;
    }

    public void setCreatetime(Timestamp createtime) {
        if(createtime!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.createtime = simpleDateFormat.format(createtime);
        }
    }

    public void setUpdatetime(Timestamp updatetime) {
        if(updatetime!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.updatetime = simpleDateFormat.format(updatetime);
        }

    }
}
