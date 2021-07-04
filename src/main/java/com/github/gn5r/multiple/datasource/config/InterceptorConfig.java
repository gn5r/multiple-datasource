package com.github.gn5r.multiple.datasource.config;

import com.github.gn5r.multiple.datasource.interceptor.DataSourceSelectInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public DataSourceSelectInterceptor dataSourceSelectInterceptor() {
        return new DataSourceSelectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dataSourceSelectInterceptor());
    }
}
