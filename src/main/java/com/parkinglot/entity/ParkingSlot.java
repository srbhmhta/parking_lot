package com.parkinglot.entity;

public class ParkingSlot {
	
	private Vehicle vehicle;
	private boolean isEmpty=true;
	private int slotId;
	
	public ParkingSlot(int slotId){
		this.slotId=slotId;
	}
	
	
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	

}
