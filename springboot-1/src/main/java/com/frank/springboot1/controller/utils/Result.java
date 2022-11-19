package com.frank.springboot1.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : springboot-1
 * @Package : com.frank.springboot1.controller.utils
 * @createTime : 2022/11/19 14:46
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Boolean status;
    private Object data;
    private String message;

    public Result(Boolean status) {
        this.status = status;
        this.data = null;
    }

    public Result(Boolean status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(Boolean status, String msg) {
        this.status = status;
        this.data = null;
        this.message = msg;
    }

}
