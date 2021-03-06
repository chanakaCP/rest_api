package com.task.restAPI.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.restAPI.dao.DeviceDaoImpl;
import com.task.restAPI.model.Device;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceDaoImpl deviceDaoImpl;
	
	public Device getDevice(int id) {
		return deviceDaoImpl.getDevice(id);
	}

	public List<Device> getAllDevices() {
		return deviceDaoImpl.getAll();
	}
	
	public Device addDevice(Device device) {
		return deviceDaoImpl.saveDevice(device);
	}
	
	public int updateDevice(int id, Device device) {
		return deviceDaoImpl.updateDevice(id, device);
	}
	
	public int deleteDevice(int id) {
		return deviceDaoImpl.deleteDevice(id);
	}

}
