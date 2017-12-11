package com.example.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by NewDarker on 2017/11/15.
 */
public class MD5Encrypt {
   private static MessageDigest md5 = null ;
   private static BASE64Encoder base64Encoder = null;
   static {
       try {
           md5 = MessageDigest.getInstance("MD5");
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }
       base64Encoder = new BASE64Encoder();
   }

    public static String toEncryptString(String psw) throws UnsupportedEncodingException {
        String encryptPsw;
        encryptPsw = base64Encoder.encode(md5.digest(psw.getBytes("utf-8")));
        return encryptPsw.substring(1,7) + encryptPsw.substring(13,19);
    }
}
