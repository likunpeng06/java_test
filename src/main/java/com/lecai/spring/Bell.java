package com.lecai.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by qatang on 14-5-8.
 */
@Component("bell1")
@Scope("prototype")
public class Bell {
    public void ring() {
        System.out.println("ringing");
    }
}
