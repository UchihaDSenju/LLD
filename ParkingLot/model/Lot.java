package model;

import model.vehicle.*;
public class Lot{
    public static int lotNumberGen = 1;
    public int lotNumber;
    private Vehicle vehicle;
    boolean isVacant;

    public Lot(){
        this.lotNumber = Lot.lotNumberGen++;
        this.isVacant = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}