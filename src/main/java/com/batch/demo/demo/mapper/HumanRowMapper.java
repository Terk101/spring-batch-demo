package com.batch.demo.demo.mapper;

import com.batch.demo.demo.dto.HumanDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HumanRowMapper implements RowMapper<HumanDTO> {
    @Override
    public HumanDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        HumanDTO humanDTO = new HumanDTO();
        humanDTO.setName(rs.getString("employeeName"));
        humanDTO.setSalary(rs.getBigDecimal("salary"));
        humanDTO.setAge(rs.getString("age"));

        return humanDTO;
    }
}
