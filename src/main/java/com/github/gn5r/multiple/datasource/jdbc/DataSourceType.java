package com.github.gn5r.multiple.datasource.jdbc;

public enum DataSourceType {

    PRIMARY("primaryDataSource"), SECONDARY("secondaryDataSource");

    private final String dataSourceName;

    DataSourceType(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getDataSourceName() {
        return this.dataSourceName;
    }
}
