package com.zl.spbm.imported.import01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:01
 */
public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        RegularBean regularBean = applicationContext.getBean(RegularBean.class);
        System.out.println(regularBean);



    }
}
