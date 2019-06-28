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
public @interface RedisLock {

    /**
     * 业务标识
     * @return
     */
    String business() default "";

    /**
     * 要锁定的key中包含的属性,支持spel。
     */
    String key();

    /**
     * 在等待时间（waitTime）内获取lock。
     * false：leaseTime是上锁以后自动解锁时间，waitTime无效
     * true: leaseTime是上锁以后自动解锁时间，waitTime时间范围内持续获取锁
     * @return boolean
     */
    boolean isWait() default true;

    /**
     * 最多等待毫秒数
     *
     */
    long waitTime() default 10000;

    /**
     * 上锁以后自动解锁毫秒数
     * 默认-1不自动解锁！
     */
    long leaseTime() default -1L;

}
