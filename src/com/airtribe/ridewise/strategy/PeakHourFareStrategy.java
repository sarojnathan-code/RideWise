package com.airtribe.ridewise.strategy;

import static com.airtribe.ridewise.Constants.EVENING_PEAK_HOUR_END;
import static com.airtribe.ridewise.Constants.EVENING_PEAK_HOUR_START;
import static com.airtribe.ridewise.Constants.MORNING_PEAK_HOUR_END;
import static com.airtribe.ridewise.Constants.MORNING_PEAK_HOUR_START;

import java.time.LocalTime;

import com.airtribe.ridewise.model.Ride;

public class PeakHourFareStrategy implements FareStrategy{

	private double PEAKHOURS_COST_PER_KM = 15;
	
	private FareStrategy nextHandler;
	
	@Override
	public double calculateFare(Ride ride) {
		double fare = 0;
		if((LocalTime.now().isAfter(MORNING_PEAK_HOUR_START) && 
				LocalTime.now().isBefore(MORNING_PEAK_HOUR_END)) 
				|| (LocalTime.now().isAfter(EVENING_PEAK_HOUR_START) && 
						LocalTime.now().isBefore(EVENING_PEAK_HOUR_END))  ) {
			
			fare = PEAKHOURS_COST_PER_KM * ride.getDistance();
		}else {
			nextHandler.calculateFare(ride); 
		}
		return fare;
	}
	
	
	@Override
    public void setNextHandler(FareStrategy nextHandler) {
        this.nextHandler = nextHandler;
    }


}
