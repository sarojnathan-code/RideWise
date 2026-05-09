package com.airtribe.ridewise.model;

public class Ride {
	
	private int id;

	private Rider rider;

	private Driver driver;

	private double distance;
	
	private FareReceipt fareReceipt;

	private RideStatus status;
	

	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
		driver.setRideCount(driver.getRideCount()+1);
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public FareReceipt getFareReceipt() {
		return fareReceipt;
	}

	public void setFareReceipt(FareReceipt fareReceipt) {
		this.fareReceipt = fareReceipt;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ride)) return false;
		Ride ride = (Ride) o;
		return this.getId() == ride.getId();
	}

	public Ride(int id, Rider rider, Driver driver, double distance, FareReceipt fareReceipt, RideStatus status) {
		super();
		this.id = id;
		this.rider = rider;
		this.driver = driver;
		this.distance = distance;
		this.fareReceipt = fareReceipt;
		this.status = status;
	}
	
	

}
