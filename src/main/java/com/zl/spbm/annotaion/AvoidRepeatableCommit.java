package com.zl.spbm.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防重复提交
 * @Author: lzhang
 * @Date: 2019/6/17 15:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidRepeatableCommit {

    /**
     *
     * @return
     */
    String key();

    /**
     * 毫秒数内不能重复调用
     * @return
     */
    long rejectTime() default 2000L;
}
