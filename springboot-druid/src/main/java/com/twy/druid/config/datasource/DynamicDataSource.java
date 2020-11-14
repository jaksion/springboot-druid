package com.twy.druid.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 它的抽象方法 determineCurrentLookupKey() 决定使用哪个数据源
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        /**
         * 通过DbContextHolder的getDbType()获取要使用的数据源
         */
        String datasource = DbContextHolder.getDbType();
        log.debug("当前使用数据源:{}", datasource);
        return datasource;
    }
}
