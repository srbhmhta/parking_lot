package com.parkinglot.service;

import java.util.List;

import com.parkinglot.dao.ParkingLotDao;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.Vehicle;

public class ParkingServiceImpl implements ParkingService {

	ParkingLotDao parkinglotDao;
	ParkingLot parkingLot;
	
	public ParkingServiceImpl(ParkingLotDao parkingLotDao) {
		this.parkinglotDao=parkingLotDao;
	}

	@Override
	public String createParkingLot(List<String> param) {
		 parkinglotDao.addParkingLot(parkinglotDao.build(param));
       return "Created a parking lot with "+param.get(0) +" slots";
	}

	@Override
	public String parkVehicle(List<String> param) {
		Vehicle vehicle= new Vehicle(param.get(0),param.get(1));
		return parkinglotDao.parkVehicle(vehicle);
		
	}

	@Override
	public String leaveVehicle(List<String> param) {
		return parkinglotDao.leaveVehicle(Integer.parseInt(param.get(0)));

		
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ParkingLotDao getParkinglotDao() {
		return parkinglotDao;
	}

	public void setParkinglotDao(ParkingLotDao parkinglotDao) {
		this.parkinglotDao = parkinglotDao;
	}

	
	
}
