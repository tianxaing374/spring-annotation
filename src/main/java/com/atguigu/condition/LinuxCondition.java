package com.atguigu.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //换取当前环境
        //-Dos.name=linux
        Environment environment = context.getEnvironment();
        return environment.getProperty("os.name").toLowerCase().contains("linux");
    }
}
