package com.frank.biteclass1.Controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SpringBoot_Demo
 * @Package : com.demo_08_ssmp.controller.utils
 * @createTime : 2022/6/11 15:31
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
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
