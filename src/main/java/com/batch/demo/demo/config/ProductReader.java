package com.batch.demo.demo.config;

import com.batch.demo.demo.dto.ProductDTO;
import com.batch.demo.demo.mapper.ProductRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.*;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ProductReader implements ItemReader<ProductDTO>, StepExecutionListener {
    private final Logger logger = LoggerFactory.getLogger(ProductReader.class);
    @Autowired
    private DataSource dataSource;

    private ExecutionContext executionContext;

    @Override
    public void beforeStep(StepExecution stepExecution) {
         executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        System.out.println("Line Reader initialized.");
        logger.debug("Line Reader initialized.");
    }

    @Override
    public ProductDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        JdbcCursorItemReader<ProductDTO> cursorItemReader = new JdbcCursorItemReader<>();
        cursorItemReader.setSql("SELECT * FROM productH2 ");
        cursorItemReader.setDataSource(dataSource);
        cursorItemReader.setRowMapper(new ProductRowMapper());
        cursorItemReader.open(executionContext);
        return cursorItemReader.read();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.debug("Line Reader ended.");
        System.out.println("Line Reader ended.");
        return ExitStatus.COMPLETED;
    }
}
