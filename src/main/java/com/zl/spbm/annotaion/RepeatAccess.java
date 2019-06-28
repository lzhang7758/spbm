package com.zl.spbm.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
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
