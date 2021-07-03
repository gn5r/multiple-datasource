package com.github.gn5r.multiple.datasource.config;

import javax.sql.DataSource;

import com.github.gn5r.multiple.datasource.jdbc.DynamicRoutingDataSourceResolver;

import org.seasar.doma.boot.autoconfigure.DomaAutoConfiguration;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(DomaAutoConfiguration.class)
public class AppConfig implements Config {

    @Autowired
    private DynamicRoutingDataSourceResolver resolver;

    @Autowired
    private Dialect dialect;

    @Override
    public DataSource getDataSource() {
        return resolver.getResolvedDefaultDataSource();
    }

    @Override
    public Dialect getDialect() {
        return this.dialect;
    }

}
