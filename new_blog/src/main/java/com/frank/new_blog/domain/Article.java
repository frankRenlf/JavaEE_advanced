package com.frank.new_blog.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.domain
 * @createTime : 2023/1/19 19:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("articleinfo")
public class Article {
    @TableId("id")
    Integer articleId;
    String title;
    String content;
    Date createTime;
    Date updateTime;
    Integer uid;
    Integer rcount;
    Integer state;
    User user;


    public Article(Integer articleId, String title, String content) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
    }

    public Article(String title, String content, Integer uid) {

        this.title = title;
        this.content = content;
        this.uid = uid;
    }

    public Article(Integer articleId, String title, String content, Timestamp createTime, Timestamp updateTime, Integer uid, Integer rcount, Integer state) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
//        if (createTime != null && updateTime != null) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.createTime = simpleDateFormat.format(createTime);
//            this.updateTime = simpleDateFormat.format(updateTime);
//        }
        this.uid = uid;
        this.rcount = rcount;
        this.state = state;
    }

//    public void setCreateTime(Timestamp createTime) {
////        this.createTime = createTime;
//        if (createTime != null) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.createTime = simpleDateFormat.format(createTime);
//        }
//    }
//
//    public void setUpdateTime(Timestamp updateTime) {
////        this.updateTime = updateTime;
//        if (updateTime != null) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.updateTime = simpleDateFormat.format(updateTime);
//        }
//    }


    public String getCreateTime() {
        if (createTime != null) {
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateformat.format(createTime);
        }
        return null;
    }

    public String getUpdateTime() {
        if (updateTime != null) {
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateformat.format(updateTime);
        }
        return null;
    }
}
