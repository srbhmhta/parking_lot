package com.parkinglot.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingSlot;
import com.parkinglot.entity.Vehicle;

public class ParkingLotDaoImpl implements ParkingLotDao{
	
	private ParkingLot parkinglot= new  ParkingLot();
	
	public ParkingLot getParkinglot() {
		return parkinglot;
	}



	public void setParkinglot(ParkingLot parkinglot) {
		this.parkinglot = parkinglot;
	}


	@Override
	public void addParkingLot(ParkingLot parkinglot) {
	   this.setParkinglot(parkinglot);
		
	}

	

	@Override
	public String parkVehicle(Vehicle vehicle) {
	   List<ParkingSlot> emptySlotList=this.getParkinglot().getParkingslotList().stream()
			                  .filter(slot->slot.isEmpty()).collect(Collectors.toList());
	   if(emptySlotList.isEmpty())
		   return "Sorry, parking lot is full";
	
	    Collections.sort(emptySlotList, Comparator.comparing(ParkingSlot::getSlotId)); 
	    synchronized (this) {
	    	int firstavailableSlotId=emptySlotList.get(0).getSlotId();
		    for(int i=0;i<getParkinglot().getParkingslotList().size();i++) {
		    	if(firstavailableSlotId==this.getParkinglot().getParkingslotList().get(i).getSlotId()) {
		    		this.getParkinglot().getParkingslotList().get(i).setVehicle(vehicle);
		    		this.getParkinglot().getParkingslotList().get(i).setEmpty(false);
		    	}
		    }	   
		   return "Allocated slot number :"+firstavailableSlotId;
		}
		
	}



	@Override
	public String leaveVehicle(int slot) {
		List<ParkingSlot> parking= this.getParkinglot().getParkingslotList().stream()
				.filter(parkingslot->parkingslot.getSlotId()==slot).collect(Collectors.toList());
	   if(parking.size()>0 && parking.size()==1) {
		      if(!parking.get(0).isEmpty()) {
			   for(int i=0;i<this.getParkinglot().getParkingslotList().size();i++) {
				   if(parking.get(0).getSlotId()==this.getParkinglot().getParkingslotList().get(i).getSlotId()) {
					   this.getParkinglot().getParkingslotList().get(i).setEmpty(true);
					   this.getParkinglot().getParkingslotList().get(i).setVehicle(null);
					   return "Slot number "+ parking.get(0).getSlotId() +" is free";
				   }
			   }
		   }  
	   }
		   return "Invalid parking slot request";
	}



	@Override
	public List<ParkingSlot> getFilledSlot() {
		 return this.getParkinglot().getParkingslotList().stream()
		.filter(slot->!slot.isEmpty()).collect(Collectors.toList());
		
	}



	@Override
	public List<String> getNumberListFromColor(String color) {
		List<String> vehicleReglist=new ArrayList<>();
		for(ParkingSlot slot:this.getFilledSlot()) {
			if(slot.getVehicle().getColor().equalsIgnoreCase(color)) {
				vehicleReglist.add(slot.getVehicle().getVehicleReg());
			}
		}
		return vehicleReglist;
	}



	@Override
	public String getslotFromRegNumber(String regNumber) {
		for(ParkingSlot parkingSlot:getFilledSlot()) {
			if(parkingSlot.getVehicle().getVehicleReg().equalsIgnoreCase(regNumber))
				return Integer.toString(parkingSlot.getSlotId());
		}
		return "Not found";
	}



	@Override
	public List<Integer> getslotFromColor(String color) {
		List<Integer> slots=new ArrayList<>();
		for(ParkingSlot slot:this.getFilledSlot()) {
			if(slot.getVehicle().getColor().equalsIgnoreCase(color)) {
				slots.add(slot.getSlotId());
			}
		}
		return slots;
	}



	@Override
	public ParkingLot build(List<String> param) {
		return getParkinglot().build(param);
	}
	
	

}
