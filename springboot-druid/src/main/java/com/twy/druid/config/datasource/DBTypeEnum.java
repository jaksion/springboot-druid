package com.twy.druid.config.datasource;

/**
 * 动态数据源枚举类
 */
public enum DBTypeEnum {
    first("first"), second("second");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
