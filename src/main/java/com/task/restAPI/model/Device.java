package com.task.restAPI.model;

public class Device {

	int id;
	String name;
	String status;
	String model;
	
	public Device() {}

	public Device(int id, String name, String status, String model ){
		this.id = id;
		this.name = name;
		this.status = status;
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", status=" + status + ", model=" + model + "]";
	}	
	
}
