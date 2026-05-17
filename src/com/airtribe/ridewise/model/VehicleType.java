package com.airtribe.ridewise.model;

public enum VehicleType {
	
	BIKE, AUTO, CAR;
	
	 public static VehicleType parseEnum(String input) {
	        try {
	            return VehicleType.valueOf(input.trim().toUpperCase());
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Invalid vehicle type: " + input);
	        }
	    }

}
