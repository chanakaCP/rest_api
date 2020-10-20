package com.task.restAPI;

import java.util.List;

import com.task.restAPI.model.Device;


public interface DeviceContInterface {

	Device getDevice(int id);
	List<Device> getAllDevices();
	
}
