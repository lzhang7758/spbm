package com.zl.spbm.aspect;

import com.alibaba.fastjson.JSONObject;
import com.zl.spbm.common.Constants;
import com.zl.spbm.common.ResultMessage;
import com.zl.spbm.utils.Codec;
import com.zl.spbm.utils.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lzhang
 * @Date: 2019/6/17 17:08
 */
@Aspect
@Component
@Slf4j
public class AvoidDuplicateAspect {

    @Autowired
    JedisUtils jedisUtils;

    @Around("@annotation(com.zl.spbm.annotaion.AvoidDuplicate)")
    public Object execute(ProceedingJoinPoint joinPoint) {
        try {
            Object result = validation(joinPoint);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ResultMessage.fail(8300, "请不要重复提交！！");
        }
    }

    public Object validation(ProceedingJoinPoint joinPoint) throws Throwable {
        String cacheKey = getCacheKey(joinPoint.toLongString(), joinPoint.getArgs());
        //redis加锁
        boolean lock = jedisUtils.tryGetDistributedLock(Constants.REDIS_ROOT, cacheKey, 60000);
        if (lock) {
            //加锁成功
            //执行方法
            Object funcResult = joinPoint.proceed();
            //方法执行完之后进行解锁
            jedisUtils.releaseDistributedLock(Constants.REDIS_ROOT + cacheKey, cacheKey);
            return funcResult;
        } else {
            //锁已存在
            return ResultMessage.fail(8300, "请不要重复提交！！");
        }
    }

    private String getCacheKey(String targetName, Object[] arguments) {
        StringBuffer sb = new StringBuffer();
        sb.append(targetName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sb.append(arguments[i] == null ? "" : getValue(arguments[i]));
            }
        }
        return Codec.encodeMd5(sb.toString());
    }

    public String getValue(Object obj) {
        if (obj.getClass().isArray()) {
            StringBuffer buf = new StringBuffer();
            Object[] array = (Object[]) obj;
            for (Object value : array) {
                if (value != null) {
                    buf.append(value.toString()).append(",");
                }
            }
            return buf.toString();
        }
        return JSONObject.toJSONString(obj);
    }

}
