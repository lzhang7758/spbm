package com.zl.spbm.redis;

import org.redisson.core.RLock;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class RedissLockUtil {
    private static DistributedLocker redissLock;

    public static void setLocker(DistributedLocker locker) {
        redissLock = locker;
    }

    /**
     * 加锁
     * @param lockKey
     * @return
     */
    public static RLock lock(String lockKey) {
        return redissLock.lock(lockKey);
    }

    /**
     * 释放锁
     * @param lockKey
     */
    public static void unlock(String lockKey) {
        redissLock.unlock(lockKey);
    }

    /**
     * 释放锁
     * @param lock
     */
    public static void unlock(RLock lock) {
        redissLock.unlock(lock);
    }


    /**
     * 带超时的锁
     * @param lockKey
     * @param unit 时间单位
     * @param timeout 超时时间
     */
    public static RLock lock(String lockKey, long timeout, TimeUnit unit) {
        return redissLock.lock(lockKey, timeout, unit);
    }

    /**
     * 尝试获取锁
     * @param lockKey key
     * @param waitTime 最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @param unit 时间单位
     * @return 是否获取到锁
     */
    public static boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
        return redissLock.tryLock(lockKey, waitTime, leaseTime, unit);
    }
}
