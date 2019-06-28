package com.zl.spbm;

import com.zl.spbm.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.RedissonClient;
import org.redisson.core.RBlockingQueue;
import org.redisson.core.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Author: lzhang
 * @Date: 2019/6/25 16:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void hello() {
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue("hello");
        blockingQueue.add("message=hello");
        String str = (String) blockingQueue.poll();
        System.out.println(str);
    }

    @Test
    public void RBLockingQueue(){
        RBlockingQueue<Object> blockingQueue =redissonClient.getBlockingDeque("userInfo");
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setPassword(DigestUtils.md5DigestAsHex(userInfo.getName().getBytes(StandardCharsets.UTF_8)));
        blockingQueue.add(userInfo);
        UserInfo userInfo1 = (UserInfo) blockingQueue.poll();
        System.out.println(userInfo1.toString());
    }

}
