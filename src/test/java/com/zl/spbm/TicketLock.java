package com.zl.spbm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程获取锁之后，将它的排队号返回，等该线程释放锁的时候，需要将该排队号传入。
 * 但这样是有风险的，因为这个排队号是可以被修改的，一旦排队号被不小心修改了，那么锁将不能被正确释放
 * 一种更好的实现方式如下 TicketLockV2
 * @Author: lzhang
 * @Date: 2019/7/5 15:09
 */
public class TicketLock {

    /**
     * 服务号
     */
    AtomicInteger serviceNum = new AtomicInteger();
    /**
     * 排队号
     */
    AtomicInteger ticketNum = new AtomicInteger();

    /**
     * lock:获取锁，如果获取成功，返回当前线程的排队号，获取排队号用于释放锁.
     */
    public int lock() {
        int currentTicketNum = ticketNum.getAndIncrement();
        while (currentTicketNum != serviceNum.get()) {
            System.out.println(String.format("currentTicketNum ={},serviceNum={}", currentTicketNum + "", serviceNum.get() + ""));
        }
        return currentTicketNum;
    }

    /**
     * 释放锁
     */
    public void unLock (int ticketnum) {
        serviceNum.compareAndSet(ticketnum,ticketnum + 1);
    }

}
