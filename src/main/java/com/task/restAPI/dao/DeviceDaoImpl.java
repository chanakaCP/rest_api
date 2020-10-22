package com.task.restAPI.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	
	@Override
	@Transactional(readOnly = true)
	public List<Device> getAll() {
		final String query = "SELECT * FROM device";
		return jdbcTemplate.query(query, (rs, rowNum) ->
			new Device(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("status"),
				rs.getString("model")
			));
	
	}
	
	
	@Override
	@Transactional
    public Device saveDevice(final Device device) {
		
        final String query = "INSERT INTO device(name,status,model) VALUES(?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query, new String[] {"id"});
				ps.setString(1, device.getName());
	        	ps.setString(2, device.getStatus());
	        	ps.setString(3, device.getModel());
	        	return ps;
			}
		}, holder);      
        int generatedId = holder.getKey().intValue();
        device.setId(generatedId);
        return device; 
    }
	
	
	@Override
	@Transactional
	public int updateDevice(int id, Device device) {
		final String query = "UPDATE device SET name=?, status=?, model=? WHERE id=?";
		return jdbcTemplate.update(query, device.getName(), device.getStatus(), device.getModel(), id);
	}
	
	@Override
	public int deleteDevice(int deviceId) {
		String query = "DELETE FROM device WHERE id = ?";
		int relust = jdbcTemplate.update(query,deviceId);
		return relust;
			
	}
	
	
}
