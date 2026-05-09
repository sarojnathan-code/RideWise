package com.airtribe.ridewise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.RideStatus;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.model.VehicleType;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.PeakHourFareStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

public class RideService {
	
	private List<Ride> rides = new ArrayList<>();
	
	private RideMatchingStrategy rideMatchingStrategy;
	

	void requestRide(VehicleType vehicleType, Rider rider,int distance) {
		Ride ride = new Ride(rider,distance);
		rides.add(ride);
	}
	
	Driver assignDriver(Rider rider, List<Driver> drivers) {
		Driver driver = rideMatchingStrategy.findDriver(rider, drivers);
		
		if(null != driver) {
			driver.setAvailable(false);
		}
		return driver;
	}
	
	void calculateFare(Ride ride) {
		FareStrategy defaultFareStrategy = new DefaultFareStrategy();
		FareStrategy peakHourFareStrategy = new PeakHourFareStrategy();
		peakHourFareStrategy.setNextHandler(defaultFareStrategy);
		peakHourFareStrategy.calculateFare(ride);
		
	}
	
	public void completeRide(int rideId) {
		for (Ride r : rides) {
	        if (r.getId() == rideId) {
	            r.setStatus(RideStatus.COMPLETED);
	            calculateFare(r);
	            System.out.println("Ride completed");
	            return;
	        }
	    }
	    System.err.println("Invalid ride id");
	}
	
	public void getAllRidesByDriver(int driverId){
		 rides.stream().filter(d -> d.getDriver().getId() == driverId).forEach(System.out::println);
	}
	
	public void getAllRidesByRider(int riderId){
	 rides.stream().filter(r -> r.getRider().getId() == riderId).forEach(System.out::println);
	}
	
	public void getAllRides(){
		rides.stream().forEach(System.out::println);
	}
}
