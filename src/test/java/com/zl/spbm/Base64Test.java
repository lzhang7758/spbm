package com.zl.spbm;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: lzhang
 * @Date: 2019/6/26 15:46
 */
public class Base64Test {

    @Test
    public void Base64(){
        Base64.Encoder encoder= Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String encoderStr = encoder.encodeToString("你好".getBytes(StandardCharsets.UTF_8));
        System.out.println("encoderStr="+encoderStr);
        String decoderStr = new String(decoder.decode(encoderStr), StandardCharsets.UTF_8);
        System.out.println("decoderStr="+decoderStr);
    }
}
