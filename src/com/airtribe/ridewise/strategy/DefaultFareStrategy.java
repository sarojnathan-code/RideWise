package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Ride;

public class DefaultFareStrategy implements FareStrategy{
	
private double PEAKHOURS_COST_PER_KM = 15;
	
	@Override
	public double calculateFare(Ride ride) {
		return PEAKHOURS_COST_PER_KM * ride.getDistance();
	}
	
	
	@Override
    public void setNextHandler(FareStrategy nextHandler) {
		
    }

}
