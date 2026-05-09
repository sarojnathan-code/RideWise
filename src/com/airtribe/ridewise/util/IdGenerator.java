package com.airtribe.ridewise.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	
	private static final IdGenerator instance = new IdGenerator();

    
    private static AtomicInteger riderIdCounter = new AtomicInteger(0);

    private  static AtomicInteger driverIdCounter = new AtomicInteger(0);

    // Private constructor
    private IdGenerator() {
    	riderIdCounter = new AtomicInteger(0);
    	driverIdCounter = new AtomicInteger(0);
    }
 // Global access
    public static IdGenerator getInstance() {
        return instance;
    }

   
    public static int generateRiderId() {
        return riderIdCounter.incrementAndGet(); // thread-safe increment
    }

    public static int generateDriverId() {
        return driverIdCounter.incrementAndGet(); // thread-safe increment
    }


}
