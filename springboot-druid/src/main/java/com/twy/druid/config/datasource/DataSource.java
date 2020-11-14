package com.twy.druid.config.datasource;

import java.lang.annotation.*;

/**
 * 自定义注解，作为aop切点使用
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    DBTypeEnum value() default DBTypeEnum.first;
}
