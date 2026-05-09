package com.airtribe.ridewise.model;

import com.airtribe.ridewise.util.IdGenerator;

public class Driver {
	
	private int id;
	private String name;
	private String currentLocation;
	private boolean available;
	private int rideCount;
	private VehicleType vehicleType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public int getRideCount() {
		return rideCount;
	}
	public void setRideCount(int rideCount) {
		this.rideCount = rideCount;
	}
	public Driver(String name, String currentLocation) {
		super();
		this.name = name;
		this.currentLocation = currentLocation;
		this.available = true;
		this.id = IdGenerator.generateDriverId();
		this.rideCount = 0;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Driver)) return false;
		Driver driver = (Driver) o;
		return this.getId() == driver.getId();
	}
	

}
