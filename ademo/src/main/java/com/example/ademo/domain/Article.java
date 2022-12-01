package com.example.ademo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.domain
 * @createTime : 2022/12/1 19:37
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
    String createTime;
    String updateTime;
    Integer uid;
    Integer rcount;
    Integer state;

    public Article(Integer userId, String username, String password, String photo, Timestamp createTime, Timestamp updateTime, Integer uid, Integer state) {
        this.articleId = userId;
        this.username = username;
        this.password = password;
        this.photo = photo;
        if (createTime != null && updateTime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.createTime = simpleDateFormat.format(createTime);
            this.updateTime = simpleDateFormat.format(updateTime);
        }
        this.state = state;
    }

    public void setCreateTime(Timestamp createTime) {
//        this.createTime = createTime;
        if (createTime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.createTime = simpleDateFormat.format(createTime);
        }
    }

    public void setUpdateTime(Timestamp updateTime) {
//        this.updateTime = updateTime;
        if (updateTime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.updateTime = simpleDateFormat.format(updateTime);
        }
    }

}
