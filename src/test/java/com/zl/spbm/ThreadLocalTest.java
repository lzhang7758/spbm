package com.zl.spbm;

import org.junit.Test;

/**
 * @Author: lzhang
 * @Date: 2019/7/4 9:37
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Test
    public void threadLocalTest() {

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
//                    try {
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        System.out.println(e.getMessage());
//                    }
                }
            } finally {
                threadLocal.remove();
            }
        }, "Thread1-").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
//                    try {
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        System.out.println(e.getMessage());
//                    }
                }
            } finally {
                threadLocal.remove();
            }
        }, "Thread2-").start();
    }

}
