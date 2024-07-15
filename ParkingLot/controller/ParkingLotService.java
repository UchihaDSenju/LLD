package controller;

public class ParkingLotService{
	private static volatile ParkingLotService parkingLotInstance = null;
	
	private ParkingLotService(){
		
	}
	
	public static ParkingLotService getParkingLotInstance(){
		if(parkingLotInstance == null){
			parkingLotInstance = new ParkingLotService();
		}
		
		return parkingLotInstance;
	}
}