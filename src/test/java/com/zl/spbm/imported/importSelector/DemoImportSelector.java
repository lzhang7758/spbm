package com.zl.spbm.imported.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:09
 */
public class DemoImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.zl.spbm.imported.importSelector.SelectorBean"};
    }
}
