package com.task.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
}
