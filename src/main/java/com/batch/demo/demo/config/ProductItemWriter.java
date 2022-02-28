package com.batch.demo.demo.config;

import com.batch.demo.demo.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemWriter implements ItemWriter<ProductDTO>, StepExecutionListener {
    private final Logger logger = LoggerFactory.getLogger(ProductItemWriter.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Item writer initial.");
        logger.debug("Item writer initial.");
    }

    @Override
    public void write(List<? extends ProductDTO> products) throws Exception {
        products.forEach(System.out::println);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("Item writer End.");
        logger.debug("Item writer End.");
        return ExitStatus.COMPLETED;
    }
}
