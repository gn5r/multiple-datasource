package com.github.gn5r.multiple.datasource.jdbc;

import java.util.Map;

import javax.sql.DataSource;

import com.google.common.collect.Maps;
import com.zaxxer.hikari.HikariDataSource;

import org.seasar.doma.boot.autoconfigure.DomaAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableConfigurationProperties(CurrentDataSource.class)
@AutoConfigureAfter(DomaAutoConfiguration.class)
@Slf4j
public class MultipleDataSourceAutoConfiguration {

    @Autowired
    private CurrentDataSource currentDataSource;

    @SuppressWarnings("unchecked")
    protected static <T> T createDataSource(DataSourceProperties properties, Class<? extends DataSource> type) {
        return (T) properties.initializeDataSourceBuilder().type(type).build();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSourceProperties secondaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary.hikari")
    HikariDataSource primaryDataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = createDataSource(properties, HikariDataSource.class);
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary.hikari")
    @ConditionalOnProperty(name = "spring.datasource.secondary.type", havingValue = "com.zaxxer.hikari.HikariDataSource")
    HikariDataSource secondaryDataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = createDataSource(properties, HikariDataSource.class);
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource;
    }

    @Bean
    @Primary
    public DynamicRoutingDataSourceResolver dynamicRoutingDataSourceResolver() {
        log.debug("動的DB切り替え");
        DataSourceContextHolder.setDataSourceType(currentDataSource.getCurrent());
        DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();

        Map<Object, Object> dataSources = Maps.newLinkedHashMap();
        dataSources.put(DataSourceType.PRIMARY.getDataSourceName(), primaryDataSource(primaryDataSourceProperties()));
        dataSources.put(DataSourceType.SECONDARY.getDataSourceName(),
                secondaryDataSource(secondaryDataSourceProperties()));

        resolver.setTargetDataSources(dataSources);

        if (DataSourceType.PRIMARY == this.currentDataSource.getCurrent()) {
            resolver.setDefaultTargetDataSource(primaryDataSource(primaryDataSourceProperties()));
        } else if (DataSourceType.SECONDARY == this.currentDataSource.getCurrent()) {
            resolver.setDefaultTargetDataSource(secondaryDataSource(secondaryDataSourceProperties()));
        }

        return resolver;
    }
}
