package com;

import java.beans.Introspector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com
 * @createTime : 2022/9/30 9:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class App2 {

    public static void main(String[] args) {
        String name = "USERFrank";
        String name2 = "UserFrank";
        System.out.println(Introspector.decapitalize(name2));
    }

}
