package com.task.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.restAPI.model.Device;
import com.task.restAPI.service.DeviceService;

@RestController
public class DeviceController implements DeviceContInterface {

	@Autowired
	private DeviceService deviceService;	
	
	@Override
	@RequestMapping(value = "/device/{id}", method = {RequestMethod.GET})
	public Device getDevice(@PathVariable("id") int id){
		Device device = deviceService.getDevice(id);
		return device;
	} 
	
	@Override
	@RequestMapping(value = "/device", method = {RequestMethod.GET})
	public List<Device> getAllDevices(){
		List<Device> deviceList = deviceService.getAllDevices();
		return deviceList;
	}
	
	@Override
	@RequestMapping(value = "/device" , method = {RequestMethod.POST})
	public Device addDevice(@RequestBody Device device){
		device = deviceService.addDevice(device);
		return device;	
	}
	
	
	
}
