package com.batch.demo.demo.config;


import com.batch.demo.demo.domain.mysql.Product;
import com.batch.demo.demo.domain.mysql.ProductRepository;
import com.batch.demo.demo.dto.ProductDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductProcessor implements ItemProcessor<ProductDTO, ProductDTO> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional("mysqlTransactionManager")
    public ProductDTO process(ProductDTO productDto) throws Exception {
        Optional<Product> productOp = productRepository.findById(productDto.getProductName());
        Product product = productOp.orElse(null);
        if (Objects.nonNull(product)) {
            if (!Objects.equals(productDto.getPrice(), product.getPrice())) {
                product.setPrice(productDto.getPrice());
                productRepository.save(product);
                return productDto;
            }
        }
        return null;
    }
}
