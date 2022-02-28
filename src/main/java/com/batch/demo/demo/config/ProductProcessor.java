package com.batch.demo.demo.config;


import com.batch.demo.demo.domain.mysql.ProductRepository;
import com.batch.demo.demo.dto.ProductDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ProductProcessor implements ItemProcessor<ProductDTO, ProductDTO> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional("mysqlTransactionManager")
    public ProductDTO process(ProductDTO productDto) throws Exception {

        return productRepository.findById(productDto.getProductName()).map(p -> {
            if (!Objects.equals(productDto.getPrice(), p.getPrice())) {
                p.setPrice(productDto.getPrice());
                productRepository.save(p);
                return productDto;
            }
            return null;
        }).orElse(null);
    }
}
