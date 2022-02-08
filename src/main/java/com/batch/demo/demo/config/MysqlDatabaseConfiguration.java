package com.batch.demo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        basePackages = {"com.batch.demo.demo.domain.mysql"}
)
public class MysqlDatabaseConfiguration {
    @Autowired
    Environment env;

    @Bean(name = "datasource2")
    @ConfigurationProperties(prefix = "database2.datasource")
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("database2.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("database2.datasource.jdbc-url"));
        dataSource.setUsername(env.getProperty("database2.datasource.username"));
        dataSource.setPassword(env.getProperty("database2.datasource.password"));
        return dataSource;
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("datasource2") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.batch.demo.demo.domain.mysql")
                .persistenceUnit("mysql")
                .build();
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

