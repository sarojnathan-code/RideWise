package com.airtribe.ridewise;

import java.util.Scanner;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();
        RideService rideService = new RideService();
        
		while(true) {
            System.out.println("\n--- RideWise ---");
            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Complete Ride");
            System.out.println("5. View Rides");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            switch (choice) {
                case 1:
                	System.out.println("1. Enter Rider name");
                	String riderName = sc.nextLine();
                	System.out.println("2. Enter Rider location");
                	String location = sc.nextLine();
                	
                	riderService.registerRider(new Rider(riderName,location));
                    break;
                case 2:
                	System.out.println("1. Enter Diver name");
                	String driverName = sc.nextLine();
                	System.out.println("2. Enter Diver location");
                	String driverLocation = sc.nextLine();
                	
                	driverService.registerDriver(new Driver(driverName, driverLocation));
                    break;
                case 3:
                	driverService.getAvailableDrivers();
                    break;
                case 4:
                	System.out.println("Enter ride id to complete ride");
                	int rideId = sc.nextInt();
                	rideService.completeRide(rideId);
                    break;
                case 5:
                    break;
                    
                case 0:
                    
                    break;
               
                default:
                    System.out.println("Invalid choice!");
            }

		}
	}

}
