package com.parkinglot.service;

import java.util.List;

public interface ParkingInfoService {

	void getStatus();

	void getRegNumberfromColorStatus(List<String> param);

	void getSlotNumberFromRegNumberStatus(List<String> param);

	void getSlotNumbersfromColorStatus(List<String> param);

}
