package com.task.restAPI.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.task.restAPI.model.Device;

public class DeviceMapper implements RowMapper<Device>{
	
	public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
        Device device = new Device();
        device.setId(rs.getInt("id"));
        device.setName(rs.getString("name"));
        device.setStatus(rs.getString("status"));
        device.setModel(rs.getString("model"));
        return device;
    }     

}
