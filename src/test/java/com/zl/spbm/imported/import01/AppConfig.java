package com.zl.spbm.imported.import01;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:01
 */
@Configuration
@Import(RegularBean.class)
public class AppConfig {

}
