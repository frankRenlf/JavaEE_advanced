package com.frank.new_blog.utils;

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

    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_FAIL = 400;

    public static final Boolean STATUS_SUCCESS = true;
    public static final Boolean STATUS_FAIL = false;

    private Integer code;
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

    public Result(Boolean status, Object data, String msg) {
        this.status = status;
        this.data = data;
        this.message = msg;
    }

    public static Result fail(Object data) {
        return new Result(Result.CODE_FAIL, Result.STATUS_FAIL, data, "fail");
    }

    public static Result success(Object data) {
        return new Result(Result.CODE_SUCCESS, Result.STATUS_SUCCESS, data, "success");
    }

}
