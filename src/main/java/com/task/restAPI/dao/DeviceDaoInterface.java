package com.task.restAPI.dao;


import java.util.List;

import com.task.restAPI.model.Device;

public interface DeviceDaoInterface {
	
	Device getDevice(int deviceId);   
	List<Device> getAll();

}
