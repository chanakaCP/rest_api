package com.task.restAPI;

import java.util.List;

import com.task.restAPI.model.Device;


public interface DeviceContInterface {

	Device getDevice(int id);
	List<Device> getAllDevices();
	Device addDevice( Device device);
	void updateDevice(int id, Device device);
	void deleteDevice(int id);

}
