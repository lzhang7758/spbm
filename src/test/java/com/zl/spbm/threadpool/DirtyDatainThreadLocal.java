package com.zl.spbm.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: lzhang
 * @Date: 2019/10/9 17:35
 */
public class DirtyDatainThreadLocal {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 2; i++) {
            MyThread myThread = new MyThread();
            pool.execute(myThread);
        }
    }

    private static class MyThread extends Thread {
        private static boolean flag = true;
        @Override
        public void run() {
            if (flag) {
                THREAD_LOCAL.set(this.getName() + ". session info.");
                flag = false;
            }
            System.out.println(this.getName() + "线程是" + THREAD_LOCAL.get());
            THREAD_LOCAL.remove();
        }

    }


}
