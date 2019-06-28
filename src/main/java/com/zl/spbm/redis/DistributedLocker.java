package com.zl.spbm.redis;

import org.redisson.core.RLock;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public interface DistributedLocker {
    RLock lock(String lockKey);

    RLock lock(String lockKey, long timeout, TimeUnit timeUnit);

    boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit timeUnit);

    void unlock(String lockKey);

    void unlock(RLock lock);
}
