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
	
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Driver(String name, String currentLocation,VehicleType vehicleType) {
		super();
		this.name = name;
		this.currentLocation = currentLocation;
		this.available = true;
		this.id = IdGenerator.generateDriverId();
		this.rideCount = 0;
		this.vehicleType = vehicleType;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Driver)) return false;
		Driver driver = (Driver) o;
		return this.getId() == driver.getId();
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", currentLocation=" + currentLocation + ", available="
				+ available + ", rideCount=" + rideCount + ", vehicleType=" + vehicleType + "]";
	}
	

	
}
