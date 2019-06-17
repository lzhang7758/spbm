package com.zl.spbm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lzhang
 * @Date: 2019/6/17 17:07
 */
public class Encode {

    /**
     * 密钥
     */
    private static long key = 1231234234l;

    /**
     * 解密 第二个参数： 和登录注册相关的：传入"true" 需要解密，比如字符串传递的，传入 nul
     *
     * @param s
     * @return
     */
    public static String decode(String s, String isLogin) {
        String res = "";
        DES des = new DES(getKey());
        byte[] sBytes = s.getBytes();
        for (int i = 0; i < (sBytes.length / 16); i++) {
            byte[] theBytes = new byte[8];
            for (int j = 0; j <= 7; j++) {
                byte byte1 = (byte) (sBytes[16 * i + 2 * j] - 'a');
                byte byte2 = (byte) (sBytes[16 * i + 2 * j + 1] - 'a');
                theBytes[j] = (byte) (byte1 * 16 + byte2);
            }
            long x = des.bytes2long(theBytes);
            byte[] result = new byte[8];
            des.long2bytes(des.decrypt(x), result);
            res = res + (new String(result));
        }
        if (isLogin != null && isLogin.equals("true")) {
            return Codec.encodeMd5(res.trim());
        }
        return res.trim();
    }

    /**
     * 加密 第二个参数：和登录注册相关的：传入"true" 需要解密，比如字符串传递的，传入 nul
     *
     * @param s
     * @return
     */
    public static String encode(String s, String isLogin) {
        String res = "";
        DES des = new DES(getKey());
        byte space = 0x20;
        byte[] sBytes = s.getBytes();
        int length = sBytes.length;
        int newLength = length + (8 - length % 8) % 8;
        byte[] newBytes = new byte[newLength];
        for (int i = 0; i < newLength; i++) {
            if (i <= length - 1) {
                newBytes[i] = sBytes[i];
            } else {
                newBytes[i] = space;
            }
        }
        for (int i = 0; i < (newLength / 8); i++) {
            byte[] theBytes = new byte[8];
            for (int j = 0; j <= 7; j++) {
                theBytes[j] = newBytes[8 * i + j];
            }
            long x = des.bytes2long(theBytes);
            byte[] result = new byte[8];
            des.long2bytes(des.encrypt(x), result);
            byte[] doubleResult = new byte[16];
            for (int j = 0; j < 8; j++) {
                doubleResult[2 * j] = (byte) (((((char) result[j]) & 0xF0) >> 4) + 'a');
                doubleResult[2 * j + 1] = (byte) ((((char) result[j]) & 0x0F) + 'a');
            }
            res = res + new String(doubleResult);
        }

        if (isLogin != null && isLogin.equals("true")) {
            return Codec.encodeMd5(res.trim());
        }
        return res;
    }

    /**
     * 获取Key
     *
     * @return long
     */
    private static long getKey() {
        return key;
    }

    /**
     * 设置Key
     *
     * @return long
     */
    public static void setKey(long enKey) {
        key = enKey;
    }

    public static void main(String[] args) {
        /** key */
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = sdf.format(date);
        System.out.println(Encode.encode("103261000000176F0B40," + datestr, null) + "    08");
        System.out.println(Encode.encode("1032810000022704A4B2," + datestr, null) + "   02");
        System.out.println(Encode.encode("a111111", null));
        System.out.println(Encode.encode("74e7d93ca4c6fda14baf667b85c28e29", null));
        System.out.println(Encode.decode("74e7d93ca4c6fda14baf667b85c28e29", "true"));
        System.out.println(Encode.encode("pnliiidgkneicjmb", null));
        System.out.println(Encode.encode("jfjerkaskafsf&,&111111", null));
        System.out.println(Codec.encodeMd5("123456"));

    }
}
