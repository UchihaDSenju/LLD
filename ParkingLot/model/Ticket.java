package model;
import java.time.*;
import model.vehicle.*;
public final class Ticket{
    private Vehicle vehicle;
    private Lot lot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, Lot lot){
        this.vehicle = vehicle;
        this.lot = lot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Lot getLot() {
        return lot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    
}