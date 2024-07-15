package controller;
import model.vehicle.*;
import exception.*;
import model.*;

import database.Database;

public class ParkingController{
	Database db;
	private static ParkingController controllerInstance;
	private ParkingController(){
		db = Database.getDatabaseInstance();
	}

	public static ParkingController getParkingControllerInstance(){
		if(controllerInstance == null){
			controllerInstance = new ParkingController();
		}

		return controllerInstance;
	}

	public void generateLots(int lotCount){
		db.addLots(lotCount);
	}

	public void parkVehicle(Vehicle vehicle){
		try {
			Lot lot = db.getLot();
			Ticket ticket = new Ticket(vehicle, lot);
			vehicle.setTicket(ticket);
			db.addVehicle(vehicle);
		} catch (LotNotFound l) {
			System.out.println(l);
		}
	}

	public void exitVehicle(String vehicleNumber){
		try{
			Vehicle vehicle  = db.getVehicle(vehicleNumber);
			Ticket ticket = vehicle.getTicket();
			Lot lot = ticket.getLot();
			int payable = 0;
			if(vehicle instanceof Car){
				
			}
			else if(vehicle instanceof Bike){

			}
		}
		catch(VehicleNotFoundException e){
			System.out.println(e);
		}
	}

	public Vehicle searchVehicle(String vehicleNumber){
		Vehicle vehicle = db.getVehicle(vehicleNumber);
		return vehicle;
	}
}