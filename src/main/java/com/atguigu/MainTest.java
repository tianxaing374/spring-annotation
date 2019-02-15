package com.atguigu;

import com.atguigu.beans.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

public class MainTest {

        @Test
        public void test1() {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
            Person person = (Person) applicationContext.getBean("person");
            System.out.println(person);
        }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person == person2);
    }

    private void printBeans(ApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test5() {
        printBeans(new AnnotationConfigApplicationContext(MainConfig2.class));
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
        /*Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);*/
    }

}
