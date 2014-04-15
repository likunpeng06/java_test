package com.lecai.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by qatang on 14-4-3.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    int length() default 0;
    String name() default "";
    boolean isPrimaryKey() default false;
    boolean isAllowNull() default true;
}
