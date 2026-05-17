package com.airtribe.ridewise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.airtribe.ridewise.model.Driver;

public class DriverService {
	
	public static List<Driver> drivers = new ArrayList<>();
	
	public void registerDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public void updateDriverAvailability(Driver driver,boolean availability){
		for (Driver d : drivers) {
	        if (d.equals(driver)) {
	            d.setAvailable(availability);
	            System.out.println("Driver availability updated");
	            return;
	        }
	    }
	    System.out.println("Driver not found");
	}
	
	
	public List<Driver> getAvailableDrivers(){
		 return drivers.stream().filter(d -> d.isAvailable()).collect(Collectors.toList());
	}
	

}
