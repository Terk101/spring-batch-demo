package com.batch.demo.demo.config;


import com.batch.demo.demo.dto.AddressDTO;
import com.batch.demo.demo.mapper.AddressRowMapper;
import com.batch.demo.demo.mapper.HumanRowMapper;
import com.batch.demo.demo.dto.HumanDTO;
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
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
@Transactional("transactionManager")
public class JobConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public JdbcCursorItemReader<AddressDTO> jdbcCursorItemReader() {
        JdbcCursorItemReader<AddressDTO> cursorItemReader = new JdbcCursorItemReader<>();

        cursorItemReader.setSql("SELECT * FROM address ");
        cursorItemReader.setDataSource(dataSource);
        cursorItemReader.setRowMapper(new AddressRowMapper());
        return cursorItemReader;
    }

    @Bean
    public ItemWriter<? super Object> itemWriter() {
        return address -> {
            System.out.println("\nWriting chunk to console");
            for (Object add : address) {
                System.out.println(add);
            }
        };
    }

    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1").chunk(3).reader(jdbcCursorItemReader()).writer(itemWriter())
                .build();
    }

    @Bean
    public Job myJob(JobRepository jobRepository,  @Qualifier("transactionManager")PlatformTransactionManager platformTransactionManager) {
        return jobBuilderFactory.get("My-First-Job").start(step1()).build();
    }

}
