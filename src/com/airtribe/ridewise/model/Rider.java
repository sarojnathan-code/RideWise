package com.airtribe.ridewise.model;

import com.airtribe.ridewise.util.IdGenerator;

public class Rider {
	
	private int id;
	private String name;
	private String location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Rider(String name, String location) {
		super();
		this.id = IdGenerator.generateRiderId();
		this.name = name;
		this.location = location;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rider)) return false;
		Rider rider = (Rider) o;
		return this.getId() == rider.getId();
	}
	
	
	

}
