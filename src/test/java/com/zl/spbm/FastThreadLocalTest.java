package com.zl.spbm;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import org.junit.Test;

/**
 * @Author: lzhang
 * @Date: 2019/7/4 9:38
 */
public class FastThreadLocalTest {

    private static FastThreadLocal<Integer> fastThreadLocal = new FastThreadLocal<>();

    @Test
    public void  threadRun(){
        new FastThreadLocalThread(() -> {
            for (int i = 0; i < 100; i++) {
                fastThreadLocal.set(i);
                System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        },"FastThreadLocalThread1-").start();

        new FastThreadLocalThread( () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
            }
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        },"FastThreadLocalThread2-").start();
    }

}
