package com.parkinglot.entity;

public class Vehicle {
  
	private  String vehicleReg;
	private String color;
	
	public Vehicle(String vehicleReg, String color) {
		this.vehicleReg=vehicleReg;
		this.color=color;
	}
	public String getVehicleReg() {
		return vehicleReg;
	}
	public void setVehicleReg(String vehicleReg) {
		this.vehicleReg = vehicleReg;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
}
