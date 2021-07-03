package com.github.gn5r.multiple.datasource.jdbc;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource")
public class CurrentDataSource {
    
    private DataSourceType current = DataSourceType.PRIMARY;

    public void setCurrent(DataSourceType current) {
        this.current = current;
    }

    public DataSourceType getCurrent() {
        return this.current;
    }
}
