package com.zl.spbm.imported.importBeanDefinitionRegistrar;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 14:22
 */
public class DemoImportRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 通过BeanDefinitionBuilder来创建一个BeanDefinition(建造者设计模式了解一下)
        // 这里也可以直接通过关键字new来创建一个BeanDefinition。由于BeanDefinition是一个接口，接口是不能new的，因此需要new它的实现类
        // 例如: GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 		 genericBeanDefinition.setBeanClass(RegistrarBean.class);
        // 上面两行代码完全是下面两行代码等价的。当然也可以new一个AnnotatedBeanDefinition。我们写的AppConfig类就是被Spring解析成一个AnnotatedBeanDefinition
        // 这里其实有很多API，例如BeanDefinitionRegistry中注册bean的方法，BeanDefinition中为bean设置相关特性的方法
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(RegisterarBean.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 上面两行代码是将RegistrarBean的解析成BeanDefinition，下面则是向Spring中注册RegistrarBean类对应的BeanDefinition
        // 注意，调用registry类的registerBeanDefinition()方法时，我们为这个Bean指定了beanName。
        registry.registerBeanDefinition("demoBean",beanDefinition);
    }
}
