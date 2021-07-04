package com.github.gn5r.multiple.datasource.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.gn5r.multiple.datasource.jdbc.CurrentDataSource;
import com.github.gn5r.multiple.datasource.jdbc.DataSourceContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

public class DataSourceSelectInterceptor implements AsyncHandlerInterceptor {

    @Autowired
    private CurrentDataSource currentDataSource;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        // ContextHolderに既定データソースをセットする
        DataSourceContextHolder.setDataSourceType(currentDataSource.getCurrent());
        
        return AsyncHandlerInterceptor.super.preHandle(request, response, handler);
    }
}
