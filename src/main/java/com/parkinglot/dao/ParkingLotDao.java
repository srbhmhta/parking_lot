package com.parkinglot.dao;

import java.util.List;

import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingSlot;
import com.parkinglot.entity.Vehicle;

public interface ParkingLotDao {
	

	void addParkingLot(ParkingLot parkinglot);

	String parkVehicle(Vehicle vehicle);

	String leaveVehicle(int slot);

	List<String> getNumberListFromColor(String string);

	List<ParkingSlot> getFilledSlot();

	String getslotFromRegNumber(String string);

	List<Integer> getslotFromColor(String string);

	ParkingLot build(List<String> param);

}
