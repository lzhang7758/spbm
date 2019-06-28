package com.zl.spbm.aspect;


import com.zl.spbm.annotaion.RedisLock;
import com.zl.spbm.annotaion.RepeatAccess;
import com.zl.spbm.exception.RedisLockException;
import com.zl.spbm.exception.RepeatException;
import com.zl.spbm.redis.RedissLockUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.core.RLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 分布式事务锁、重复提交 aop
 * @Author: lzhang
 * @Date: 2019/6/17 15:59
 */
@Aspect
@Component
public class RedissonAspect {
    @Value("${spring.application.name}")
    private String appName;
    private ExpressionParser parser = new SpelExpressionParser();
    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Around("@annotation(redisLock)")
    public Object lockAround(ProceedingJoinPoint pjp, RedisLock redisLock) throws Throwable {
        StringBuilder redisKey = new StringBuilder(getKey());
        if(!"".equals(redisLock.business())) {
            redisKey.append(redisLock.business()).append(":");
        }
        redisKey.append(getParam(pjp, redisLock.key()));
        //执行分布式锁的逻辑
        if(redisLock.isWait()) {
            if(redisLock.waitTime() > -1) {
                boolean res = RedissLockUtil.tryLock(redisKey.toString(), redisLock.waitTime(), redisLock.leaseTime(), TimeUnit.MILLISECONDS);
                if(res) {
                    try {
                        return pjp.proceed();
                    } finally {
                        RedissLockUtil.unlock(redisKey.toString());
                    }
                } else {
                    throw new RedisLockException("在毫秒时间"+redisLock.waitTime()+"内没有获取到锁！");
                }
            } else {
                throw new RedisLockException("waitTime不能小于0！");
            }
        } else {
        	if(redisLock.leaseTime() > -1) {
        		RLock lock = RedissLockUtil.lock(redisKey.toString(), redisLock.leaseTime(), TimeUnit.MILLISECONDS);
                try {
                    return pjp.proceed();
                } finally {
                    RedissLockUtil.unlock(lock);
                }
            } else {
                throw new RedisLockException("leaseTime不能小于0！");
            }
        }
    }

    @Around("@annotation(repeatAccess)")
    public Object repeatAround(ProceedingJoinPoint pjp, RepeatAccess repeatAccess) throws Throwable {
        if(repeatAccess.rejectTime() < 1) {
            throw new RepeatException("rejectTime 不能小于1！");
        }
        StringBuilder redisKey = new StringBuilder(getKey());
        String params = getParam(pjp, repeatAccess.key());
        if(!"".equals(params)) {
            redisKey.append(DigestUtils.md5DigestAsHex(params.getBytes("UTF-8")));
        }
        boolean res = RedissLockUtil.tryLock(redisKey.toString(), 0, repeatAccess.rejectTime(), TimeUnit.MILLISECONDS);
        if(res) {
            return pjp.proceed();
        } else {
            throw new RepeatException("重复访问！");
        }
    }

    private String getKey() {
        if(!"".equals(appName)) {
            return appName + ":";
        }
        return "";
    }

    private String getParam(ProceedingJoinPoint pjp, String temp) {
        if(temp == null || "".equals(temp)) {
            return "";
        }
        //获取方法上的注解对象
        Object[] args = pjp.getArgs();
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        Expression expression = parser.parseExpression(temp);
        return expression.getValue(context)+"";
    }
}
