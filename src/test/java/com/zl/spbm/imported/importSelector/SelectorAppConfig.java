package com.zl.spbm.imported.importSelector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:11
 */
@Configuration
@Import(DemoImportSelector.class)
public class SelectorAppConfig {
}
