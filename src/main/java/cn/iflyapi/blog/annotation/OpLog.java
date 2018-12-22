package cn.iflyapi.blog.annotation;

import cn.iflyapi.blog.enums.OperationEnum;

import java.lang.annotation.*;

/**
 * @author flyhero
 * @date 2018-12-21 2:42 PM
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {

    OperationEnum op() default OperationEnum.ARTICLE_READ;

    int score() default 0;

}
