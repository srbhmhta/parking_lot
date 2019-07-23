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
	public StringBuilder getStatus() {
		StringBuilder builder= new StringBuilder();
		builder.append("Slot No."+ "\t").append("Registration No" + "\t").append("Colour");
		for(ParkingSlot slot:parkingLotDao.getFilledSlot()) {
			builder.append("\n"+slot.getSlotId() + "\t");
			builder.append(slot.getVehicle().getVehicleReg() + "\t");
			builder.append(slot.getVehicle().getColor());

		}
		return builder;
	}

	@Override
	public String getRegNumberfromColorStatus(List<String> param) {
		return parkingLotDao.getNumberListFromColor(param.get(0)).toString();
		
	}

	@Override
	public String getSlotNumberFromRegNumberStatus(List<String> param) {
		return parkingLotDao.getslotFromRegNumber(param.get(0));
		
	}

	public ParkingLotDao getParkingLotDao() {
		return parkingLotDao;
	}

	public void setParkingLotDao(ParkingLotDao parkingLotDao) {
		this.parkingLotDao = parkingLotDao;
	}

	@Override
	public List<Integer> getSlotNumbersfromColorStatus(List<String> param) {
		return parkingLotDao.getslotFromColor(param.get(0));

		
	}
	
	

}
