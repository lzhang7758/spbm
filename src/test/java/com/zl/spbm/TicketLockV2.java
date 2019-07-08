package com.zl.spbm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lzhang
 * @Date: 2019/7/5 15:16
 */
public class TicketLockV2 {

    /**
     * 服务号
     */
    AtomicInteger serviceNum = new AtomicInteger();
    /**
     * 排队号
     */
    AtomicInteger ticketNum = new AtomicInteger();
    /**
     *  新增一个ThreadLocal，用于存储每个线程的排队号
     */
    ThreadLocal<Integer> ticketNumHolder = new ThreadLocal<>();

    /**
     *
     * @return
     */
    public int lock () {
       int currentTicketNum = ticketNum.incrementAndGet();
       ticketNumHolder.set(currentTicketNum);
       while (currentTicketNum != serviceNum.get()){
           System.out.println(String.format("currentTicketNum ={},serviceNum={}", currentTicketNum + "", serviceNum.get() + ""));
       }
       return currentTicketNum;
    }

    public void unlock() {
        // 释放锁，从ThreadLocal中获取当前线程的排队号
        Integer currentTickNum = ticketNumHolder.get();
        serviceNum.compareAndSet(currentTickNum, currentTickNum + 1);
    }
}
