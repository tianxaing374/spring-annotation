package com.atguigu.config;

import com.atguigu.beans.Person;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration //告诉Spring这是一个配置类
@ComponentScan(value = "com.atguigu",includeFilters = {
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),*/
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class}),
},useDefaultFilters = false) //XML配置也需要禁用默认过滤规则

/*@ComponentScans(value = {
        @ComponentScan(value = "com.atguigu",includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
        },useDefaultFilters = false),
        @ComponentScan(value = "com.atguigu",includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})
        },useDefaultFilters = false)
})*/

public class MainConfig {

    @Bean("person") //类型为返回值类型，id默认为方法名
    public Person person01(){
        return new Person("lisi",20);
    }

}
