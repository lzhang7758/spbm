package com.zl.spbm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class ProfiledemoApplication {
	Logger logger = LoggerFactory.getLogger(ProfiledemoApplication.class);

    @Bean
    public Object logger(PlatformTransactionManager platformTransactionManager){
    	logger.info("platformTransactionManager.getClass().getName()=>>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProfiledemoApplication.class, args);
    }
}
