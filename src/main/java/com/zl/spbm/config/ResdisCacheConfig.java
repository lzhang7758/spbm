package com.zl.spbm.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**   
 * Author: qk203   Date: 2018年2月8日  
 * Copyright @ 2018 Corpration Name   
 */
public class ResdisCacheConfig extends CachingConfigurerSupport {

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuffer sb = new StringBuffer();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for(Object obj : params) {
					sb.append(obj.toString());
				}
				return sb;
			}
		};
	}
	
	/**
	 * 管理缓存
	 * @param redisTemplate
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
		//设置缓存过期时间 单位：秒
         rcm.setDefaultExpiration(60);
        return rcm;
	}
	
	/**
	 * RedisTemplate配置
	 * @param connectionFactory
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory){
		StringRedisTemplate redisTemplate = new StringRedisTemplate(connectionFactory);
		@SuppressWarnings("unchecked")
		Jackson2JsonRedisSerializer jackser = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackser.setObjectMapper(om);
		redisTemplate.setValueSerializer(jackser);
		//如果key是String 需要配置一下StringSerializer,不然key会乱码 /XX/XX
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	
}
