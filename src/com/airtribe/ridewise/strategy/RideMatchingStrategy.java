package com.airtribe.ridewise.strategy;

import java.util.List;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

public interface RideMatchingStrategy {
	
	Driver findDriver(Rider rider, List<Driver> drivers);

}
