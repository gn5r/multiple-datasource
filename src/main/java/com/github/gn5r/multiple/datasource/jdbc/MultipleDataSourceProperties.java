package com.github.gn5r.multiple.datasource.jdbc;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

public class MultipleDataSourceProperties extends DataSourceProperties {

    private HikariDataSource hikari = createDataSource(this, HikariDataSource.class);

    public MultipleDataSourceProperties(String dataSourceName) {
        this.hikari = this.createDataSource(this, HikariDataSource.class);
        this.hikari.setPoolName(dataSourceName);
    }

    public void setHikari(HikariDataSource hikari) {
        this.hikari = hikari;
    }

    public HikariDataSource getHikari() {
        return this.hikari;
    }

    @SuppressWarnings("unchecked")
    private <T> T createDataSource(DataSourceProperties properties, Class<? extends DataSource> type) {
        return (T) properties.initializeDataSourceBuilder().type(type).build();
    }

}
