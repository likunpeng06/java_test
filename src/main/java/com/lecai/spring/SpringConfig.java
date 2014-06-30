package com.lecai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by qatang on 14-5-8.
 */

@Configuration

@ImportResource("classpath:spring/bike-beans.xml")
public class SpringConfig {
    @Bean
    @Autowired
    public Bike bike() {
        return new Bike();
    }

    @Bean
    public Bell bell() {
        return new Bell();
    }
}
