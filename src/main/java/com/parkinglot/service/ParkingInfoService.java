package com.parkinglot.service;

import java.util.List;

public interface ParkingInfoService {

	StringBuilder getStatus();

	String getRegNumberfromColorStatus(List<String> param);

	String getSlotNumberFromRegNumberStatus(List<String> param);

	List<Integer> getSlotNumbersfromColorStatus(List<String> param);

}
