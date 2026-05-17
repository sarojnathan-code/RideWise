package com.airtribe.ridewise.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.ridewise.model.Rider;

public class RiderService {
	
	public static List<Rider> riders = new ArrayList<>();
	
	public void registerRider(Rider rider) {
		riders.add(rider);
	}
	
	public Rider searchRider(int riderId) {
		return riders.stream().filter(r -> r.getId() == riderId).findFirst().orElse(null);
	}

}
