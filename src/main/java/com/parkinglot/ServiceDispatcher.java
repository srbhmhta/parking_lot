package com.parkinglot;

import java.util.List;

import com.parkinglot.service.ParkingInfoService;
import com.parkinglot.service.ParkingService;

public class ServiceDispatcher {

	
	ParkingService parkingService;
	ParkingInfoService parkingninfoService;
	
    public void dispatch(String command, List<String> param){
		 switch (command) {
		
		 case "create_parking_lot":
			 parkingService.createParkingLot(param);
			break;
		 case "park":
			 parkingService.parkVehicle(param);
				break;
		 case "leave":
			 parkingService.leaveVehicle(param);
				break;
		 case "status":
			 parkingninfoService.getStatus();
				break;
		 case "registration_numbers_for_cars_with_colour":
			 parkingninfoService.getRegNumberfromColorStatus(param);
				break;
		 case "slot_numbers_for_cars_with_colour":
			 parkingninfoService.getSlotNumbersfromColorStatus(param);
				break;
		 case "slot_number_for_registration_number":
			 parkingninfoService.getSlotNumberFromRegNumberStatus(param);
				break;

		default:
			break;
		}
	}

	public ParkingService getParkingService() {
		return parkingService;
	}

	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	public ParkingInfoService getParkingninfoService() {
		return parkingninfoService;
	}

	public void setParkingninfoService(ParkingInfoService parkingninfoService) {
		this.parkingninfoService = parkingninfoService;
	}
	
	
	
}
