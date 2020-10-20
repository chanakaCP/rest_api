package com.task.restAPI.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.task.restAPI.model.Device;

@Repository
public class DeviceDaoImpl  implements DeviceDaoInterface{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	@Transactional(readOnly = true) 
	public Device getDevice(int deviceId) {
		final String query = "SELECT * FROM device WHERE id = ?";
		Device device = jdbcTemplate.queryForObject(query, new Object[] {deviceId},(rs, rowNum) ->
			new Device(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("status"),
				rs.getString("model")
			));
		return device;	
	}
	
	
	
	
}
