package com.zl.spbm.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.google.common.collect.Sets;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.resource.ClientResources;
import com.lambdaworks.redis.resource.DefaultClientResources;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.DefaultLettucePool;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Set;

/**
 *
 */
@Configuration
@EnableCaching
@ConditionalOnClass({RedisOperations.class, RedisClient.class})
@EnableConfigurationProperties({RedisProperties.class})
public class LettuceAutoConfiguration {
    @Autowired
    private RedisProperties properties;

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnMissingBean(ClientResources.class)
    public DefaultClientResources lettuceClientResources() {
        return DefaultClientResources.create();
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory f;
        if(this.properties.getSentinel().getNodes() != null) {
            Set<String> sentinelHostAndPorts = Sets.newHashSet(this.properties.getSentinel().getNodes().split(","));
            f = new LettuceConnectionFactory(
                new RedisSentinelConfiguration(this.properties.getSentinel().getMaster(), sentinelHostAndPorts)
            );
        } else if(this.properties.getCluster().getNodes() != null) {
            Set<String> sentinelHostAndPorts = Sets.newHashSet(this.properties.getCluster().getNodes());
            f = new LettuceConnectionFactory(
                new RedisClusterConfiguration(sentinelHostAndPorts)
            );
        } else {
            if(this.properties.getPool() != null) {
                RedisProperties.Pool pool = this.properties.getPool();
                GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
                poolConfig.setMaxIdle(pool.getMaxIdle());
                poolConfig.setMaxTotal(pool.getMaxActive());
                poolConfig.setMinIdle(pool.getMinIdle());
                f = new LettuceConnectionFactory(
                    new DefaultLettucePool(this.properties.getHost(), this.properties.getPort(), poolConfig)
                );
            } else {
                f = new LettuceConnectionFactory(this.properties.getHost(), this.properties.getPort());
            }
        }
        return f;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(1800);
        return cacheManager;
    }

    /**
     * RedisTemplate
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        return redisTemplate;
    }
}
