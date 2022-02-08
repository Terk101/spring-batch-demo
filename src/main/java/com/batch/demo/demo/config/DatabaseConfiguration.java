package com.batch.demo.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

//    @Autowired
//    Environment env;
//
//    @Bean(name= "datasource")
//    @ConfigurationProperties(prefix="database1.datasource")
//    @Primary
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("database1.datasource.driverClassName"));
//        dataSource.setUrl(env.getProperty("database1.datasource.url"));
//        dataSource.setUsername(env.getProperty("database1.datasource.username"));
//        dataSource.setPassword(env.getProperty("database1.datasource.password"));
//        return dataSource;
//    }
//
//
//    @Bean(name= "datasource2")
//    @ConfigurationProperties(prefix="database2.datasource")
//    public DataSource dataSource2() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("database2.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("database2.datasource.jdbc-url"));
//        dataSource.setUsername(env.getProperty("database2.datasource.username"));
//        dataSource.setPassword(env.getProperty("database2.datasource.password"));
//        return dataSource;
//    }


//    @Bean(name="tm1")
//    @Autowired
//    @Primary
//    DataSourceTransactionManager transaction1(@Qualifier("datasource") DataSource datasource) {
//        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
//        return txm;
//    }
//
//    @Bean(name="tm2")
//    @Autowired
//    DataSourceTransactionManager transaction2(@Qualifier ("datasource2") DataSource datasource) {
//        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
//        return txm;
//    }
}
