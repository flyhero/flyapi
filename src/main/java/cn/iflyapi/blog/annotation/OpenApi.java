package cn.iflyapi.blog.annotation;

import java.lang.annotation.*;

/**
 * @author flyhero
 * @date 2018-12-20 11:40 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenApi {

    String value() default "";
}
