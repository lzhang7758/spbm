package com.zl.spbm.threadpool;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: lzhang
 * @Date: 2019/10/9 13:33
 */
public class MyTask implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_"+count.getAndIncrement());
    }
}
