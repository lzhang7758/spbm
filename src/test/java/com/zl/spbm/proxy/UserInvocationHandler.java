package com.zl.spbm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 13:14
 */
public class UserInvocationHandler implements InvocationHandler {

    private Object target;

    public UserInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocation handler");
        // 通过反射调用目标对象的方法
        return method.invoke(target,args);
    }
}
