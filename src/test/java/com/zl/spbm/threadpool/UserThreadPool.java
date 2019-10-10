package com.zl.spbm.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lzhang
 * @Date: 2019/10/9 13:43
 */
public class UserThreadPool {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(2);

        UserThreadFactory f1 = new UserThreadFactory("001");
        UserThreadFactory f2 = new UserThreadFactory("002");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutorFirst = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS,queue,f1,handler);
        ThreadPoolExecutor threadPoolExecutorSecond = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS,queue,f2,handler);

        Runnable task = new MyTask();

        for (int i = 0; i <200 ; i++) {
            threadPoolExecutorFirst.execute(task);
            threadPoolExecutorSecond.execute(task);
        }


    }


}
