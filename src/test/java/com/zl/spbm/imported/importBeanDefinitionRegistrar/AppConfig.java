package com.zl.spbm.imported.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:21
 */
@Configuration
@Import(DemoImportRegistrar.class)
public class AppConfig {
}
