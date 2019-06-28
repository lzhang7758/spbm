package com.zl.spbm.config;

import com.zl.spbm.redis.DistributedLocker;
import com.zl.spbm.redis.RedissLockUtil;
import com.zl.spbm.redis.RedissonDistributedLocker;
import org.redisson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {
    @Autowired
    private RedissonProperties redssionProperties;

    /**
     * 哨兵模式自动装配
     * @return
     */
    @Bean
    @ConditionalOnProperty(name="spring.redisson.master-name")
    RedissonClient redissonSentinel() {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(redssionProperties.getSentinelAddresses())
            .setMasterName(redssionProperties.getMasterName())
            .setTimeout(redssionProperties.getTimeout())
            .setMasterConnectionPoolSize(redssionProperties.getMasterConnectionPoolSize())
            .setSlaveConnectionPoolSize(redssionProperties.getSlaveConnectionPoolSize());

        if(!StringUtils.isEmpty(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        return Redisson.create(config);
    }

    /**
     * 单机模式自动装配
     * @return
     */
    @Bean
    @ConditionalOnProperty(name="spring.redisson.address")
    RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
            .setAddress(redssionProperties.getAddress())
            .setTimeout(redssionProperties.getTimeout())
            .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
            .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());
        if(!StringUtils.isEmpty(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        return Redisson.create(config);
    }

    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     * @return
     */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Bean
    DistributedLocker distributedLocker(RedissonClient redissonClient) {
        DistributedLocker locker = new RedissonDistributedLocker(redissonClient);
        RedissLockUtil.setLocker(locker);
        return locker;
    }

}
