package com.zl.spbm.aspect;

import com.zl.spbm.annotaion.AvoidRepeatableCommit;
import com.zl.spbm.common.Constants;
import com.zl.spbm.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 防止重复提交aop
 *
 * @Author: lzhang
 * @Date: 2019/6/17 15:59
 */
@Aspect
@Component
@Slf4j
public class AvoidRepeatableCommitAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Around("@annotation(com.zl.spbm.annotaion.AvoidRepeatableCommit)")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.currentRequestAttributes();
        String ip = HttpUtil.getIpAddr(request);

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();

        String className = method.getDeclaringClass().getName();
        String name = method.getName();
        String ipKey = String.format("%s#%s", className, name);
        int hashCode = Math.abs(ipKey.hashCode());

        String key = Constants.REDIS_ROOT + String.format("%s_%d", ip, hashCode);
        log.info("ipCey={},hasCode={},key={}", ip, hashCode, key);

        AvoidRepeatableCommit avoidRepeatableCommit = method.getAnnotation(AvoidRepeatableCommit.class);
        long timeOut = avoidRepeatableCommit.timeout();
        if (timeOut < 0) {
            timeOut = 3 * Constants.SECOND;
        }
        String value = redisTemplate.opsForValue().get(key) + "";
        if (!StringUtils.isEmpty(value)) {
            return "请勿重复提交";
        }
        redisTemplate.opsForValue().set(key, UUID.randomUUID(),timeOut, TimeUnit.SECONDS);

        Object object = point.proceed();
        return object;
    }

}
