package com.zl.spbm.threadlocal;

import com.lambdaworks.redis.output.StatusOutput;
import io.swagger.models.auth.In;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: lzhang
 * @Date: 2019/10/9 15:35
 */
public class CsGameThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIVE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;

    //为了展示每个对象的不同的数据
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };

    private static final ThreadLocal<Integer> LIVE_VALUE_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return LIVE_VALUE;
        }
    };

    private static class Player extends Thread {
        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS / 2);
            Integer lifeValue = LIVE_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LIVE_VALUE);

            System.out.println(getName() + ",BULLET_NUMBER is " + bullets);
            System.out.println(getName() + ",KILLED_ENEMIES is " + killEnemies);
            System.out.println(getName() + ",LIVE_VALUE is " + lifeValue);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Player().start();
        }
    }

}
