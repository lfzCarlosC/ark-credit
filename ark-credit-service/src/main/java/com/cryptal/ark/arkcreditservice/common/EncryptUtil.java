package com.cryptal.ark.arkcreditservice.common;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    public static String md5(String password){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");//利用哈希算法，MD5
            byte[] input = password.getBytes();
            byte[] output = md.digest(input);
            return Base64.encodeBase64String(output);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("密码加密失败");
            return "";
        }
    }

}
