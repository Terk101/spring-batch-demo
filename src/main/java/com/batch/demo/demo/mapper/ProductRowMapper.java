package com.batch.demo.demo.mapper;

import com.batch.demo.demo.dto.ProductDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDTO> {
    @Override
    public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(rs.getString("PName"));
        productDTO.setPrice(rs.getBigDecimal("Price"));
        productDTO.setCategory(rs.getString("Category"));
        productDTO.setManufacturer(rs.getString("Manufacturer"));
        return productDTO;
    }
}
