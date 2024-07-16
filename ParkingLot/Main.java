import controller.*;
import model.vehicle.*;;
class Main{
	public static void main(String[] args){
		ParkingController controller = ParkingController.getParkingControllerInstance();

		controller.generateLots(25);

		controller.parkVehicle(new Car("TN 12322"));
		controller.parkVehicle(new Car("TN 32155"));
		controller.parkVehicle(new Bike("TN 39001"));
		
		controller.exitVehicle("3332");
		controller.exitVehicle("TN 39001");
		
	}
}