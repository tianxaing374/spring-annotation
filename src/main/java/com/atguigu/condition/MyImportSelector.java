package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    //AnnotationMetadata
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(importingClassMetadata.getAnnotationTypes());
        return new String[]{"com.atguigu.beans.Blue","com.atguigu.beans.Yellow"};
    }
}
