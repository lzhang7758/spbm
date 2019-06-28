package com.zl.spbm.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防重复提交
 * @Author: lzhang
 * @Date: 2019/6/28 16:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RepeatAccess {
    /**
     * 支持spel。
     * @return
     */
    String key();

    /**
     * 毫秒数内不能重复调用
     * @return
     */
    long rejectTime() default 2000;
}
