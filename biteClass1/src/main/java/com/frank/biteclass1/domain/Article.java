package com.frank.biteclass1.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.domain
 * @createTime : 2022/10/3 16:29
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @TableId
    private Integer id;
    private String title;
    private Date publish;
    private byte[] content;
    private Integer userId;

}
