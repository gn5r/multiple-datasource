package com.github.gn5r.multiple.datasource.jdbc;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MultipleDataSourceAutoConfiguration.class)
public class DomaConfig implements Config {

    @Autowired
    private DynamicRoutingDataSourceResolver dataSource;

    @Autowired
    private Dialect dialect;

    @Override
    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public Dialect getDialect() {
        return this.dialect;
    }

}
