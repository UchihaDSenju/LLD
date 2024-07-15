package database;
import java.util.ArrayList;
import java.util.TreeSet;

import model.vehicle.*;
import model.*;
import exception.*;

public class Database{
    private static Database databaseInstance = null;

    private ArrayList<Vehicle> parkedVehicles = new ArrayList<>();
    private TreeSet<Lot> lots = new TreeSet<>((l1, l2) -> Integer.compare(l1.lotNumber, l2.lotNumber));
    private Database(){
    }

    public static Database getDatabaseInstance(){
        if(databaseInstance == null){
            databaseInstance = new Database();
        }

        return databaseInstance;
    }

    // Write methods
    public void addVehicle(Vehicle vehicle){
        parkedVehicles.add(vehicle);
    }

    public void addLots(int lotCount){
        for(int i = 0; i<lotCount; i++){
            lots.add(new Lot());
        }
    }

    //Read Methods
    public Vehicle getVehicle(String vehicleNumber){
        for(Vehicle vehicle : parkedVehicles){
            if(vehicle.vehicleNumber.equals(vehicleNumber)){
                return vehicle;
            }
        }
        throw new VehicleNotFoundException();
    }

    public Lot getLot(){
        if(lots.size() == 0) throw new LotNotFound();
        return lots.pollFirst();
    }
}