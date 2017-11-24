package com.flyapi.core.annotation;

import java.lang.annotation.*;

/**
 * Author: qfwang
 * Date: 2017-11-24 下午5:26
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableFlyapiLog {
    String description() default "";
}
