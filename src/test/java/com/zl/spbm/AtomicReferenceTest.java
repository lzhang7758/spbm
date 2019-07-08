package com.zl.spbm;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: lzhang
 * @Date: 2019/7/5 15:00
 */
public class AtomicReferenceTest {

    AtomicReference<Thread> cas = new AtomicReference<>();

    private int count;

    public void lock() {
        Thread current = Thread.currentThread();
        // 如果当前线程已经获取到了锁，线程数增加一，然后返回
        if (current == cas.get()) {
            count++;
            return;
        }

        // 如果没获取到锁，则通过CAS自旋
        while (!cas.compareAndSet(null, current)) {

        }

    }

    public void unLock() {
        Thread cur = new Thread();
        if (cur == cas.get()) {
            // 如果大于0，表示当前线程多次获取了该锁，释放锁通过count减一来模拟
            if (count > 0) {
                count--;

                // 如果count==0，可以将锁释放，这样就能保证获取锁的次数与释放锁的次数是一致的了
            } else {
                cas.compareAndSet(cur, null);
            }
        }

    }
}
