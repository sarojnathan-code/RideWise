package com.airtribe.ridewise.service;

import java.util.ArrayList;
import java.util.List;

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

	void requestRide(VehicleType vehicleType, Rider rider) {
		
	}
	
	void assignDriver(RideMatchingStrategy rideMatchingStrategy) {
		
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
	            System.out.println("Ride completed");
	            return;
	        }
	    }
	    System.err.println("Invalid ride id");
	}
}
