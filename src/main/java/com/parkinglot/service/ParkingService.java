package com.parkinglot.service;

import java.util.List;

public interface ParkingService {

	void createParkingLot(List<String> param);

	void parkVehicle(List<String> param);

	void leaveVehicle(List<String> param);


}
