package model.vehicle;
import model.Ticket;
abstract public class Vehicle{
    public String vehicleNumber;
    private Ticket ticket;

    Vehicle(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    
}