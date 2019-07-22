package com.parkinglot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.parkinglot.dao.ParkingLotDao;
import com.parkinglot.dao.ParkingLotDaoImpl;
import com.parkinglot.service.ParkingInfoService;
import com.parkinglot.service.ParkingInfoServiceImpl;
import com.parkinglot.service.ParkingService;
import com.parkinglot.service.ParkingServiceImpl;

public class Main {
   public static void main(String[] args) throws IOException {
	   System.out.println(":::::::Starting PARKING SERVCE:::::::");
	   ServiceDispatcher serviceDispatcher = init();
	   
	   boolean x=true;
	   if(args.length>0 && args[0].contains(".txt")) {
		   String fileName = "/Users/pankaj/source.txt";
		   Path path = Paths.get(fileName);
		   byte[] bytes = Files.readAllBytes(path);
		   List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);  
		   for(String line:allLines) {
		  	 String[] inputParam= line.split(" ");
		  	List<String> param=Arrays.asList(inputParam);
		  	param.remove(0);
		  	serviceDispatcher.dispatch(inputParam[0],param);
		   }
	   }else {
		   while(x) {
		   Scanner sc= new Scanner(System.in);
		   String request= sc.nextLine();
		   String[] inputParam= request.split(" ");
		   List<String> param=new ArrayList<String>();
		   for(int i=1;i<inputParam.length;i++) {
			   param.add(inputParam[i]);
		   }
		   if(inputParam[0].equalsIgnoreCase("exit")) {
			   x=false;
		   }
		  	serviceDispatcher.dispatch(inputParam[0],param);
	   }
	
	   }
	 
	
   }

	private static ServiceDispatcher init() {
		ParkingLotDao parkingLotDao = new ParkingLotDaoImpl();
		ServiceDispatcher serviceDispatcher = new ServiceDispatcher();
		ParkingService parkingService = new ParkingServiceImpl(parkingLotDao);
		ParkingInfoService parkingInfoService = new ParkingInfoServiceImpl(parkingLotDao);
		serviceDispatcher.setParkingninfoService(parkingInfoService);
		serviceDispatcher.setParkingService(parkingService);
      return serviceDispatcher;
	}
}
