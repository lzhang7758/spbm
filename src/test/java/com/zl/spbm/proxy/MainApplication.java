package com.zl.spbm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 13:15
 */
public class MainApplication {

    public static void main(String[] args) {
        // 让代理对象的class文件写入到磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ClassLoader classLoader = MainApplication.class.getClassLoader();
        // 为代理对象指定要是实现哪些接口，这里我们要为UserServiceImpl这个目标对象创建动态代理，所以需要为代理对象指定实现UserService接口
        Class[] classes = new Class[]{UserService.class};
        // 初始化一个InvocationHandler，并初始化InvocationHandler中的目标对象
        InvocationHandler invocationHandler = new UserInvocationHandler(new UserServiceImpl());
        // 创建动态代理
        UserService userService = (UserService) Proxy.newProxyInstance(classLoader,classes,invocationHandler);
        userService.insert();
    }
}
