package com.parkinglot.service;

import java.util.List;

import com.parkinglot.dao.ParkingLotDao;
import com.parkinglot.entity.ParkingSlot;

public class ParkingInfoServiceImpl implements ParkingInfoService{

	
	ParkingLotDao parkingLotDao;
	
	
	public ParkingInfoServiceImpl(ParkingLotDao parkingLotDao) {
		this.parkingLotDao=parkingLotDao;
	}

	@Override
	public void getStatus() {
		System.out.print("Slot No." + "\t");
		System.out.print("Registration No" + "\t");
		System.out.println("Colour");
		for(ParkingSlot slot:parkingLotDao.getFilledSlot()) {
			System.out.print(slot.getSlotId() + "\t");
			System.out.print(slot.getVehicle().getVehicleReg() + "\t");
			System.out.println(slot.getVehicle().getColor());

		}
		
	}

	@Override
	public void getRegNumberfromColorStatus(List<String> param) {
		System.out.println(parkingLotDao.getNumberListFromColor(param.get(0)).toString());
		
	}

	@Override
	public void getSlotNumberFromRegNumberStatus(List<String> param) {
		System.out.println(parkingLotDao.getslotFromRegNumber(param.get(0)));
		
	}

	public ParkingLotDao getParkingLotDao() {
		return parkingLotDao;
	}

	public void setParkingLotDao(ParkingLotDao parkingLotDao) {
		this.parkingLotDao = parkingLotDao;
	}

	@Override
	public void getSlotNumbersfromColorStatus(List<String> param) {
		System.out.println(parkingLotDao.getslotFromColor(param.get(0)));

		
	}
	
	

}
