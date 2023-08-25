package service;

import models.ParkingLot;
import models.Slot;
import models.Ticket;
import models.Vehicle;

import java.util.Objects;

public class ParkingServiceImpl implements ParkingService{

    ParkingLot parkingLot = null;

    public ParkingServiceImpl(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle){
        Slot slot = parkingLot.findAvailableSlotInParkingLot(vehicle.getVehicleType());
        if(Objects.isNull(slot)){
            System.out.println("Parking not available");
            return null;
        }
        slot.occupySlot();
        return new Ticket(generateTicketId(parkingLot.getParkingLotId(), slot), vehicle, slot);
    }

    @Override
    public void unparkVehicle(Ticket ticket){
        if (Objects.isNull(ticket)){
            System.out.println("Invalid parking");
        } else {
            ticket.getSlot().freeSlot();
        }
    }

    private String generateTicketId(String parkingLotId, Slot slot){
        return parkingLotId + "_" + slot.getFloorNumber() + "_" + slot.getSlotNumber();
    }
}
