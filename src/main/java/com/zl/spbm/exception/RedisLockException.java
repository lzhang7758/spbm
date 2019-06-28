package com.zl.spbm.exception;

/**
 * @Author: lzhang
 * @Date: 2019/6/27 13:47
 */
public class RedisLockException extends RuntimeException {

    public RedisLockException(String message){
        super(message);
    }
}
