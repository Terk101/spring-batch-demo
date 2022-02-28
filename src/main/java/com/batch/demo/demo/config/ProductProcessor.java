package com.batch.demo.demo.config;


import com.batch.demo.demo.domain.mysql.ProductRepository;
import com.batch.demo.demo.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductProcessor implements ItemProcessor<ProductDTO, ProductDTO>, StepExecutionListener {
    private final Logger logger = LoggerFactory.getLogger(ProductProcessor.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Line processor initialized.");
        logger.debug("Line processor initialized.");
    }

    @Override
    @Transactional("mysqlTransactionManager")
    public ProductDTO process(ProductDTO productDto) throws Exception {
        logger.debug("Line process {} ", productDto);
        return productDto;
//        productRepository.findById(productDto.getProductName()).orElse(null);
//        return productRepository.findById(productDto.getProductName()).map(p -> {
//            if (!Objects.equals(productDto.getPrice(), p.getPrice())) {
//                p.setPrice(productDto.getPrice());
//                productRepository.save(p);
//                return productDto;
//            }
//            return null;
//        }).orElse(null);
    }


    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.debug("Line Processor ended.");
        System.out.println("Line Processor ended.");
        return ExitStatus.COMPLETED;
    }
}
