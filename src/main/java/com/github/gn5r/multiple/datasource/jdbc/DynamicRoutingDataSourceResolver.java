package com.github.gn5r.multiple.datasource.jdbc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        if (DataSourceContextHolder.getDataSourceType() == DataSourceType.PRIMARY) {
            return DataSourceType.PRIMARY.getDataSourceName();
        } else if (DataSourceContextHolder.getDataSourceType() == DataSourceType.SECONDARY) {
            return DataSourceType.SECONDARY.getDataSourceName();
        }

        return DataSourceType.PRIMARY.getDataSourceName();
    }
}
