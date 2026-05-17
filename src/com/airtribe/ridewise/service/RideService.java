package com.airtribe.ridewise.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.RideStatus;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.model.VehicleType;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.LeastActiveDriverStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.PeakHourFareStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

public class RideService {
	
	public static List<Ride> rides = new ArrayList<>();
	
	private RideMatchingStrategy rideMatchingStrategy;
	

	public void requestRide(VehicleType vehicleType, Rider rider,int distance,String rideType) {
		Ride ride = new Ride(rider,distance,vehicleType);
		
		assignDriver(rider,DriverService.drivers,rideType, ride);
		rides.add(ride);
	}
	
	public Driver assignDriver(Rider rider, List<Driver> drivers,String rideType,Ride ride) {
		if(rideType.equalsIgnoreCase("Prime")) {
			rideMatchingStrategy = new NearestDriverStrategy();
		}else {
			rideMatchingStrategy = new LeastActiveDriverStrategy();
		}
		Driver driver = rideMatchingStrategy.findDriver(rider, drivers,ride);
		
		if(null != driver) {
			driver.setAvailable(false);
			
		}
		
		if(ride != null) {
			ride.setDriver(driver);
			ride.setStatus(RideStatus.ASSIGNED);
		}
		return driver;
	}
	
	double calculateFare(Ride ride) {
		FareStrategy defaultFareStrategy = new DefaultFareStrategy();
		FareStrategy peakHourFareStrategy = new PeakHourFareStrategy();
		peakHourFareStrategy.setNextHandler(defaultFareStrategy);
		return peakHourFareStrategy.calculateFare(ride);
		
	}
	
	public void completeRide(int rideId) {
		for (Ride r : rides) {
	        if (r.getId() == rideId && r.getStatus().equals(RideStatus.ASSIGNED)) {
	            r.setStatus(RideStatus.COMPLETED);
	            calculateFare(r);
	            System.out.println("Thank you for riding with RideWise.");
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
