package com.airtribe.ridewise.strategy;

import java.util.List;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

public class NearestDriverStrategy implements RideMatchingStrategy{

	@Override
	public Driver findDriver(Rider rider, List<Driver> drivers) {
		int locaton = Integer.parseInt(rider.getLocation());
		
		return  drivers.stream()

	            // Only available drivers
	            .filter(Driver::isAvailable)

	            // Find nearest driver
	            .min((d1, d2) -> {

	                int distance1 = Math.abs(
	                        Integer.parseInt(d1.getCurrentLocation()) - locaton);

	                int distance2 = Math.abs(
	                        Integer.parseInt(d2.getCurrentLocation()) - locaton);

	                return Integer.compare(distance1, distance2);
	            })

	            .orElse(null);
	}

}
