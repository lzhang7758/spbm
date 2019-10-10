package com.zl.spbm.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lzhang
 * @Date: 2019/10/9 13:26
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    UserThreadFactory(String whatFeatureOfGroup){
        namePrefix = "UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + atomicInteger.getAndIncrement();
        Thread thread = new Thread(null , r, name,0);
        System.out.println(thread.getName());
        return thread;
    }
}
