package com.lecai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by qatang on 14-5-8.
 */
@Component
public class Bike {
    private String name;
    private int size;

    @Autowired
    private Bell bell;

    public void start() {
        System.out.println("bike starts");
    }

    public void stop() {
        System.out.println("bike stops");
    }

    public void ring() {
        bell.ring();
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PostConstruct
    public void init2() {
        System.out.println("init2");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
