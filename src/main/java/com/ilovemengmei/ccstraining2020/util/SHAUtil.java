package com.ilovemengmei.ccstraining2020.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtil {

    public static String hash(String context){
        try {
            System.out.println("SHA-256 hook ！");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return new BigInteger(1, md.digest(context.getBytes())).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}