package com.airtribe.ridewise.strategy;

import java.util.List;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{

	@Override
	public Driver findDriver(Rider rider, List<Driver> drivers) {

		return drivers.stream().min((d1,d2) -> { 
			return Integer.compare(d1.getRideCount(), d2.getRideCount());
		}).orElse(null);
	}

}
