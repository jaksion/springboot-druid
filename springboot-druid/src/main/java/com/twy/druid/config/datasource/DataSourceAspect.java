package com.twy.druid.config.datasource;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceAspect {
    /**
     * 设置路径下的文件都使用这个数据源
     */
//    //设置该路径下dao使用first数据源
//    @Pointcut("execution(* com.twy.druid.dao.first..*.*(..))")
//    private void firstAspect() {
//    }
//    //设置该路径下dao使用second数据源
//    @Pointcut("execution(* com.twy.druid.dao.second..*.*(..))")
//    private void secondAspect() {
//    }

//    @Before("dataSourcePointCut()")
//    public void first() {
//        log.info("切换到first数据源...");
//        DbContextHolder.setDbType(DBTypeEnum.first);
//    }
//
//    @Before("secondAspect()")
//    public void second() {
//        log.info("切换到second数据源...");
//        DbContextHolder.setDbType(DBTypeEnum.second);
//    }

    /**
     * 切点: 所有配置 DataSource 注解的方法
     */
    @Pointcut("@annotation(com.twy.druid.config.datasource.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        // 通过判断 DataSource 中的值来判断当前方法应用哪个数据源
        DbContextHolder.setDbType(ds.value());
        log.info("AOP切换数据源成功，数据源为：" + ds.value());
        log.info("设置数据源为：" + ds.value());
        try {
            return point.proceed();
        } finally {
            DbContextHolder.clearDbType();
            log.info("clean datasource");
        }
    }
}