package com.github.gn5r.multiple.datasource.jdbc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("データソースタイプ:" + DataSourceContextHolder.getDataSourceType());
        if (DataSourceContextHolder.getDataSourceType() == DataSourceType.PRIMARY) {
            return DataSourceType.PRIMARY.getDataSourceName();
        } else if (DataSourceContextHolder.getDataSourceType() == DataSourceType.SECONDARY) {
            return DataSourceType.SECONDARY.getDataSourceName();
        }

        return DataSourceType.PRIMARY.getDataSourceName();
    }
}
