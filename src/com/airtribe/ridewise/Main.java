package com.airtribe.ridewise;

import java.util.List;
import java.util.Scanner;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.model.VehicleType;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
       
        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();
        RideService rideService = new RideService();
        
		while(true) {
            System.out.println("\n--- RideWise ---");
            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Request Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. View Rides");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                	System.out.println("1. Enter Rider name");
                	sc.nextLine();
                	String riderName = sc.nextLine();
                	
                	System.out.println("2. Enter Rider location");
                	String location = sc.nextLine();
                	
                	riderService.registerRider(new Rider(riderName,location));
                    break;
                case 2:
                	System.out.println("1. Enter Diver name");
                	sc.nextLine();
                	String driverName = sc.nextLine();
                	System.out.println("2. Enter Diver location");
                	String driverLocation = sc.nextLine();
                	System.out.println("Enter vehicle type (Bike, Car, Auto)");
                	String newVehicleType = sc.nextLine();
                	VehicleType newVehicle = VehicleType.parseEnum(newVehicleType);
                	
                	driverService.registerDriver(new Driver(driverName, driverLocation,newVehicle));
                    break;
                case 3:
                	List<Driver> drivers = driverService.getAvailableDrivers();
                	drivers.stream().forEach(System.out::println);
                    break;
                case 4:
                	System.out.println("Enter rider id to request ride");
                	int rideId = sc.nextInt();
                	Rider rider = riderService.searchRider(rideId);
                	System.out.println("Enter vehicle type for ride (Bike, Car, Auto)");
                	sc.nextLine();
                	String vehicleType = sc.nextLine();
                	VehicleType vehicle = VehicleType.parseEnum(vehicleType);
                	System.out.println("Enter destination distance");
                	int distance = sc.nextInt();
                	System.out.println("Enter ride type (Prime, Regular)");
                	sc.nextLine();
                	String rideType = sc.nextLine();
                	rideService.requestRide(vehicle,rider,distance,rideType);
                    break;
                case 5:
                	System.out.println("Enter ride id to complete ride");
                	int rideIdCompleteRide = sc.nextInt();
                	rideService.completeRide(rideIdCompleteRide);
                    break;
                case 6:
                	viewRides(sc);
                    break;
                    
                case 0:
                    
                    break;
               
                default:
                    System.out.println("Invalid choice!");
            }

		}
	}
	
	private static void viewRides(Scanner sc) {
        int subChoice;
        RideService rideService = new RideService();
        
        while(true) {
            System.out.println("\n--- View Rides---");
            System.out.println("1. View Rides by Driver");
            System.out.println("2. View Rides by Rider");
            System.out.println("3. View all rides");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            subChoice = sc.nextInt();

            switch (subChoice) {
                case 1:
                	System.out.println("Enter driver Id to view rides");
                	int driverId = sc.nextInt();
                	rideService.getAllRidesByDriver(driverId);
                    break;
                case 2:
                	System.out.println("Enter rider Id to view rides");
                	int riderId = sc.nextInt();
                	rideService.getAllRidesByRider(riderId);
                    break;
                case 3:
                	rideService.getAllRides();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    return;
               
                default:
                    System.out.println("Invalid choice!");
            }

        } 
    }

}
