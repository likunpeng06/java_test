package com.lecai.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qatang on 14-5-8.
 */
public class SpringTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/bike-beans.xml");

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Bike bike = (Bike)annotationConfigApplicationContext.getBean("bike");

        bike.start();
        bike.ring();

        annotationConfigApplicationContext.destroy();
    }
}
