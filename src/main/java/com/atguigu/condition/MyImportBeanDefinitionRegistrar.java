package com.atguigu.condition;

import com.atguigu.beans.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    //AnnotationMetadata 当前类的注解信息
    //BeanDefinitionRegistry 手工注册bean
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.atguigu.beans.Red");
        boolean blue = registry.containsBeanDefinition("com.atguigu.beans.Blue");
        if(red && blue){
            //指定Bean定义的信息，Bean的类型，scope等等
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
            //注册一个Bean，指定bean名
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
