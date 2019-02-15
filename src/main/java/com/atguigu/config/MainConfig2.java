package com.atguigu.config;

import com.atguigu.beans.Color;
import com.atguigu.beans.Person;
import com.atguigu.beans.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Conditional({WindowsCondition.class})//满足条件，这个类中注册的bean才能生效
@Configuration
@Import({Color.class, Red.class,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) //组件名，id默认是组件的全类名
public class MainConfig2 {

    @Scope("singleton")
    @Lazy
    //默认是单实例的，ioc容器启动会调用方法，将对象放到IOC容器中
    //      针对单实例bean，容器启动不创建对象，第一次使用时再创建
    //prototype，启动不会创建，每次获取才会调用方法创建对象
    @Bean
    public Person person(){
        System.out.println("给容器中添加Person实例");
        return new Person("张三",25);
    }

    @Bean("bill")

    public Person person01(){
        return new Person("Bill",60);
    }

    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person02(){
        return new Person("linus",50);
    }

    /*
    * 给容器中注册组件
    * 1、包扫描+组件标注注解(@Controller/@Service/@Repository/@Component) 自己写
    * 2、@Bean（导入第三方包里面的组件）
    * 3、@Import（快速的给容器中导入一个组件）
    *       组件名，id默认是组件的全类名
    *       ImportSelector：全类名数组
    *       ImportBeanDefinitionRegistrar
    * */


}
