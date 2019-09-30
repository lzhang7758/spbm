package com.zl.spbm.imported.importSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:13
 */
public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SelectorAppConfig.class);
        SelectorBean selectorBean = applicationContext.getBean(SelectorBean.class);
        System.out.println(selectorBean);
    }
}
