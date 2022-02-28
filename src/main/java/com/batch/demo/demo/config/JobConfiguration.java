package com.batch.demo.demo.config;


import com.batch.demo.demo.dto.ProductDTO;
import com.batch.demo.demo.mapper.ProductRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private ProductProcessor productProcessor;

    @Bean
    public JdbcCursorItemReader<ProductDTO> jdbcCursorItemReader() {
        JdbcCursorItemReader<ProductDTO> cursorItemReader = new JdbcCursorItemReader<>();

        cursorItemReader.setSql("SELECT * FROM productH2 ");
        cursorItemReader.setDataSource(dataSource);
        cursorItemReader.setRowMapper(new ProductRowMapper());
        return cursorItemReader;
    }

    @Bean
    public ItemWriter<ProductDTO> itemWriter() {
        return product -> {
            System.out.println("\nWriting chunk to console");
            for (Object add : product) {
                System.out.println(add);
            }
        };
    }

    @Bean
    public Step step1(@Qualifier("transactionManager")PlatformTransactionManager platformTransactionManager) {
        return this.stepBuilderFactory.get("step1").<ProductDTO, ProductDTO>chunk(3)
                .reader(jdbcCursorItemReader()).processor(productProcessor)
                .writer(itemWriter())
                .transactionManager(platformTransactionManager)
                .build();
    }

    @Bean
    public Job myJob(JobRepository jobRepository,  @Qualifier("transactionManager")PlatformTransactionManager platformTransactionManager) {
        return jobBuilderFactory.get("My-First-Job").start(step1(platformTransactionManager)).build();
    }

}
