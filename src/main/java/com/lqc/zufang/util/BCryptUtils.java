package com.lqc.zufang.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/12 9:31
 */
public class BCryptUtils {
    public static String bCryptEncode() {
        String password = "123123";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));

        String candidate = "123123";
        if (BCrypt.checkpw(candidate, hashed)) {
            System.out.println("It matches");
        }else{
            System.out.println("It does not match");
        }
         return "asd";
    }
    public static void main(String... args){
        bCryptEncode();
    }
}
