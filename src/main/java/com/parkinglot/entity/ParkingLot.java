package com.parkinglot.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	private List<ParkingSlot> parkingslotList= new ArrayList<>();

	public List<ParkingSlot> getParkingslotList() {
		return parkingslotList;
	}

	public void setParkingslotList(List<ParkingSlot> parkingslotList) {
		this.parkingslotList = parkingslotList;
	}

	public ParkingLot build(List<String> param) {
		int totalparking =Integer.parseInt(param.get(0));
		for(int i=0;i<totalparking;i++) {
			this.getParkingslotList().add(new ParkingSlot(i+1));
		}
		return this;
	}
	
	
	

}
