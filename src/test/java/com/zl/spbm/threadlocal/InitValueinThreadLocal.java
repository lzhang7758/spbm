package com.zl.spbm.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lzhang
 * @Date: 2019/10/9 16:27
 */
public class InitValueinThreadLocal {
    private static final StringBuilder INIT_VALUE = new StringBuilder("init");

    private static final ThreadLocal<StringBuilder> THREAD_LOCAL_BUILDER = new ThreadLocal<StringBuilder>(){
        @Override
        protected StringBuilder initialValue() {
            return INIT_VALUE;
        }
    };

    private static class AppendStringThread extends Thread{
        @Override
        public void run() {
            StringBuilder stringBuilder = THREAD_LOCAL_BUILDER.get();
            for (int i = 0; i <100 ; i++) {
                stringBuilder.append("-"+ i);
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <100 ; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }

}
