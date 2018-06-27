package com.githup.template.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.SQLException;

/**
 * @description: 数据源配置
 * @author: wufenyun
 * @date: 2018-06-13 18
 **/
@Configuration
public class DatasourceConfig {
    @Value("${jdbc.driverClass}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.initsize:10}")
    private int initialSize;
    @Value("${jdbc.maxactive:20}")
    private int maxActive;

    @Bean("dataSource")
    @Primary
    public DruidDataSource configDatasource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setDriverClassName(driverClassName);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setMaxActive(maxActive);
        datasource.setInitialSize(initialSize);
        datasource.setValidationQuery("select 1;");
        datasource.setTestOnBorrow(false);
        datasource.setTestWhileIdle(true);
        datasource.setTimeBetweenEvictionRunsMillis(10000);
        datasource.setMinEvictableIdleTimeMillis(60000);
        datasource.setLogAbandoned(true);
        datasource.setRemoveAbandoned(true);
        datasource.setRemoveAbandonedTimeout(180);
        try {
            datasource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }
}