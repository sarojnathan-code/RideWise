package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Ride;

public class DefaultFareStrategy implements FareStrategy{
	
private double PEAKHOURS_COST_PER_KM = 15;
	
	@Override
	public double calculateFare(Ride ride) {
		double cost = PEAKHOURS_COST_PER_KM * ride.getDistance();
		System.out.println("Total fare for ride is "+cost);
		return cost;
	}
	
	
	@Override
    public void setNextHandler(FareStrategy nextHandler) {
		
    }

}
