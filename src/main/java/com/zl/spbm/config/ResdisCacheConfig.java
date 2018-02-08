package com.zl.spbm.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
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
     * RedisTemplate配置
     * @param factory
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    	
//    	GenericToStringSerializer：使用Spring转换服务进行序列化；
//    	JacksonJsonRedisSerializer：使用Jackson 1，将对象序列化为JSON；
//    	Jackson2JsonRedisSerializer：使用Jackson 2，将对象序列化为JSON；
//    	JdkSerializationRedisSerializer：使用Java序列化；
//    	OxmSerializer：使用Spring O/X映射的编排器和解排器（marshaler和unmarshaler）实现序列化，用于XML序列化；
//    	StringRedisSerializer：序列化String类型的key和value。实际上是String和byte数组之间的转换
    	
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //定义key序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //定义value的序列化方式
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
	
}
