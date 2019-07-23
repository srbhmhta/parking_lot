package com.parkinglot.service;

import java.util.List;

public interface ParkingService {

	String createParkingLot(List<String> param);

	String parkVehicle(List<String> param);

	String leaveVehicle(List<String> param);


}
