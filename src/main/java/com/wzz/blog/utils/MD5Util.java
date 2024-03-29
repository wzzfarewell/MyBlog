package com.wzz.blog.utils;

import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;

public class MD5Util {

    @Value("${password.salt}")
    private static String passwordSalt;

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * 返回大写MD5
     * @param origin
     * @param charsetname
     * @return
     */
    private static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception ignored) {
        }
        return resultString.toUpperCase();
    }

    public static String MD5EncodeUtf8WithSalt(String origin){
        return MD5Encode(origin + PropertiesUtil.getProperty("password.salt", ""), "utf-8");
    }

    public static String MD5EncodeUtf8(String origin) {
        return MD5Encode(origin, "utf-8");
    }

    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

//    public static void main(String[] args) {
//        System.out.println(MD5Util.MD5EncodeUtf8("123456"));
//        System.out.println(MD5Util.MD5EncodeUtf8WithSalt("123456"));
//        System.out.println(passwordSalt);
//    }

}
