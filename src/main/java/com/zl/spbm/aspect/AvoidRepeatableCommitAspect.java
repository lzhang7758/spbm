package com.zl.spbm.aspect;

import com.zl.spbm.annotaion.AvoidRepeatableCommit;
import com.zl.spbm.exception.RepeatException;
import com.zl.spbm.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
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

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    RedissonClient redissonClient;


    ExpressionParser parser = new SpelExpressionParser();
    LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Around("@annotation(avoidRepeatableCommit)")
    public Object around(ProceedingJoinPoint point, AvoidRepeatableCommit avoidRepeatableCommit) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.currentRequestAttributes();
        String ip = HttpUtil.getIpAddr(request) + "";
        StringBuilder redisKey = new StringBuilder(ip + getKey());
        String params = getParam(point, avoidRepeatableCommit.key());
        if (StringUtils.isEmpty(params)) {
            redisKey = redisKey.append(":").append(DigestUtils.md5DigestAsHex(params.getBytes(StandardCharsets.UTF_8)));
        }
        RLock rLock = redissonClient.getLock(redisKey.toString());
        boolean boo = rLock.tryLock(0, avoidRepeatableCommit.rejectTime(), TimeUnit.MILLISECONDS);
        if (boo) {
            return point.proceed();
        } else {
            throw new RepeatException("请勿重复提交");
        }
    }

    private String getKey() {
        if (!"".equals(appName)) {
            return appName + ":";
        }
        return "";
    }

    private String getParam(ProceedingJoinPoint pjp, String temp) {
        if (temp == null || "".equals(temp)) {
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
        return expression.getValue(context, String.class);
    }

}

