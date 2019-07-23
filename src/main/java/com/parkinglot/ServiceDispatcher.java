package com.parkinglot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import com.parkinglot.service.ParkingInfoService;
import com.parkinglot.service.ParkingService;

public class ServiceDispatcher {

	
	ParkingService parkingService;
	ParkingInfoService parkingninfoService;
	
    public void dispatch(String command, List<String> param){
         
    	switch (command) {
		
		 case "create_parking_lot":
			System.out.println( parkingService.createParkingLot(param));
			break;
		 case "park":
			 System.out.println(parkingService.parkVehicle(param));
				break;
		 case "leave":
			 System.out.println(parkingService.leaveVehicle(param));
				break;
		 case "status":
			 System.out.println(parkingninfoService.getStatus());
				break;
		 case "registration_numbers_for_cars_with_colour":
			 System.out.println(parkingninfoService.getRegNumberfromColorStatus(param));
				break;
		 case "slot_numbers_for_cars_with_colour":
			 System.out.println(parkingninfoService.getSlotNumbersfromColorStatus(param));
				break;
		 case "slot_number_for_registration_number":
			 System.out.println(parkingninfoService.getSlotNumberFromRegNumberStatus(param));
				break;

		default:
			System.out.println("Invalid input try again");
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
