package service;

import models.Ticket;
import models.Vehicle;

public interface ParkingService {

    public Ticket parkVehicle(Vehicle vehicle);

    public void unparkVehicle(Ticket ticket);
}
