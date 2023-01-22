package com.frank.new_blog.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : new_blog
 * @Package : com.frank.new_blog.utils
 * @createTime : 2023/1/22 17:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description : encrypt and add salt
 */
public class SecurityUtil {
    /*
     * encrypt
     *
     */
    public static String encrypt(String password) {
        String salt = UUID.randomUUID().toString().replace("-", "");
        return salt + DigestUtils.md5DigestAsHex((salt + password).getBytes(StandardCharsets.UTF_8));
    }

    /*
     * decrypt
     *
     */
    public static Boolean decrypt(String password, String finalPass) {
        if (!StringUtils.hasLength(password) || !StringUtils.hasLength(finalPass)) {
            return false;
        }
        if (finalPass.length() != 64) {
            return false;
        }
        String salt = finalPass.substring(0, 32);
        // use salt to generate final by password
        String securityPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes(StandardCharsets.UTF_8));
        return (salt + securityPassword).equals(finalPass);
    }

    public static void main(String[] args) {
        String password = "123";
        System.out.println(encrypt(password));
        // 7c646e2790984d95ae8cc0fc509efd785eb8afdfba28350e93da77989d843ed3
    }
}
