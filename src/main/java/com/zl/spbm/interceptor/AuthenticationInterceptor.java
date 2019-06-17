package com.zl.spbm.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.zl.spbm.annotaion.CurrentUser;
import com.zl.spbm.annotaion.HashRequired;
import com.zl.spbm.annotaion.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: lzhang
 * @Date: 2019/6/13 15:04
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate<String, Object> redis;

    @Value("${hashkey.web}")
    private String key;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        HashRequired hashRequired = method.getAnnotation(HashRequired.class);
        CurrentUser currentUser = method.getAnnotation(CurrentUser.class);

        if (loginRequired != null) {
            String token = request.getHeader("authorization");
            if (StringUtils.isEmpty(token)) {
                response.sendError(401, "no header,try login !");
                return false;
            }

            String name = null;
            try {
                name = JWT.decode(token).getAudience().get(0);
                if (currentUser != null) {
                    request.setAttribute("user", name);
                }

            } catch (JWTDecodeException e) {
                response.sendError(401, "wrong token!");
                return false;
            }

            String redisToken = redis.opsForHash().get("tokens", name).toString();
            if (StringUtils.isEmpty(redisToken)) {
                response.sendError(401, "token invalid ,try login!");
                return false;
            }
            return true;
        }

        //校验token
        if (hashRequired != null) {
            String hashKey = request.getHeader("hashKey");
            if (StringUtils.isEmpty(hashKey)) {
                response.sendError(401, "no key,reject !");
                return false;
            }

            if (!key.equals(hashKey)) {
                response.sendError(401, "wrong key,reject !");
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
