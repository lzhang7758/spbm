package com.zl.spbm.aspect;

import com.alibaba.fastjson.JSON;
import com.zl.spbm.exception.RepeatException;
import com.zl.spbm.utils.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 日志
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {
    private static final String LOGGER_CONTEXT_KEY = "contextId";
    @Pointcut("execution(* com.zl.spbm.controller..*(..))")
    public void controller() {
    }

    /**
     * 执行前准备.
     * 输出传入参数
     *
     * @param jp JoinPoint
     */
    @Before("controller()")
    public void controllerBefore(final JoinPoint jp) throws Throwable {
        MDC.put(LOGGER_CONTEXT_KEY, UUID.randomUUID().toString());
        if (log.isInfoEnabled()) {
            List<Object> l = Arrays.asList(jp.getArgs()).stream().filter(o -> !(o instanceof BindingResult)).collect(Collectors.toList());
            log.info("{}.{} input param: {}", jp.getTarget().getClass(), jp.getSignature().getName(), JSON.toJSONString(l));
        }
    }

    /**
     * 执行后返回.
     * 日志输出.
     *
     * @param jp  JoinPoint
     * @param obj 返回值
     * @throws Throwable ex
     */
    @AfterReturning(pointcut = "controller()", returning = "obj")
    public void controllerBefore(final JoinPoint jp, final Object obj) throws Throwable {
        if (log.isInfoEnabled()) {
            log.info("{}.{} export param:{}", jp.getTarget().getClass(), jp.getSignature().getName(), JSON.toJSONString(obj));
        }
        MDC.remove(LOGGER_CONTEXT_KEY);
    }

    @Around("controller()")
    public Object afterAnnotation(final ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        List<Parameter> vs = Arrays.stream(signature.getMethod().getParameters())
                .filter(ar -> ar.getAnnotation(Validated.class) != null || ar.getAnnotation(Valid.class) != null)
                .collect(Collectors.toList());
        if(vs != null && !vs.isEmpty()) {
            Object[] objects = pjp.getArgs();
            //寻找带BindingResult参数的方法，然后判断是否有error，如果有则是校验不通过
            BeanPropertyBindingResult result = (BeanPropertyBindingResult) Arrays.asList(objects).stream()
                    .filter(o -> o instanceof BeanPropertyBindingResult && ((BeanPropertyBindingResult) o).getAllErrors().size() > 0)
                    .findFirst().orElse(null);
            if (result != null) {
                StringBuffer err = new StringBuffer("error:");
                List<ObjectError> obes = result.getAllErrors();
                for (ObjectError error : obes) {
                    if (log.isDebugEnabled()) {
                        log.debug("{} --- {} --- {}", error.getCode(), error.getArguments(), error.getDefaultMessage());
                    }
                    err.append(error.getDefaultMessage()).append(";");
                }
                return BaseResult.fail(err.toString());
            }
        }
        try {
            return pjp.proceed();
        } catch (RepeatException re) {
            log.info("RepeatException: {}", re.getMessage());
            return BaseResult.ok();
        } catch (Exception e) {
            log.error("pjp.proceed() error: ", e);
            return BaseResult.fail(e.getMessage());
        }
    }
}
