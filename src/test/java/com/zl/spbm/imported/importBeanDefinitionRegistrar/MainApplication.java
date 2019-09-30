package com.zl.spbm.imported.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:28
 */
public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        RegisterarBean bean = applicationContext.getBean(RegisterarBean.class);
        System.out.println(bean);

        RegisterarBean demoBean = (RegisterarBean) applicationContext.getBean("demoBean");
        System.out.println(demoBean);
    }
}
