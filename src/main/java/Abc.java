/**
 * Created by qatang on 14-2-19.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//RetentionPolicy.SOURCE RetentionPolicy.CLASS RetentionPolicy.RUNTIME 分别对应java源文件 class文件 内存中的字节码
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Abc {
    String color() default "blue";
    String value();//当注解只有一个value值时，可以直接写值
}

//@Abc(value="10")
