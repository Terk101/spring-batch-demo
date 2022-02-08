package com.batch.demo.demo.mapper;

import com.batch.demo.demo.dto.AddressDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper  implements RowMapper<AddressDTO> {
    @Override
    public AddressDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setHouseNo(rs.getString("houseNo"));
        addressDTO.setSoi(rs.getString("soi"));
        addressDTO.setStreet(rs.getString("street"));
        return addressDTO;
    }
}
