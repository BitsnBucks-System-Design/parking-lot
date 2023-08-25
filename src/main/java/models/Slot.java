package models;

import Constants.SlotStatus;
import Constants.VehicleType;
import lombok.Data;

@Data
public class Slot {
    private VehicleType vehicleType;
    private Long slotNumber;
    private Long floorNumber;
    private SlotStatus status;

    public Slot(VehicleType vehicleType, Long slotNumber, Long floorNumber){
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
        status = SlotStatus.FREE;
    }

    public void occupySlot(){
        this.status = SlotStatus.OCCUPIED;
    }

    public void freeSlot(){
        this.status = SlotStatus.FREE;
    }

}


