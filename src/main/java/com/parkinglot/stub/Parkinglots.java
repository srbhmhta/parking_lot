package com.parkinglot.stub;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.entity.*;


public class Parkinglots {
     
	private List<ParkingLot> parkinglotList= new ArrayList<>();

	public List<ParkingLot> getParkinglotList() {
		return parkinglotList;
	}

	public void setParkinglotList(List<ParkingLot> parkinglotList) {
		this.parkinglotList = parkinglotList;
	}
     
     
     
}
