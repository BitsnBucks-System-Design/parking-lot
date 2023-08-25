package models;

import Constants.SlotStatus;
import Constants.VehicleType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class ParkingLot {
    private String parkingLotId;
    private Long numberOfFloors;
    private List<Floor> floorList;

    public ParkingLot(String parkingLotId, Long numberOfFloors, Long numberOfSlots){
        this.parkingLotId = parkingLotId;
        this.numberOfFloors = numberOfFloors;
        this.floorList = new ArrayList<>();
        allotFloorstoParkingLot(numberOfSlots);
    }

    private void allotFloorstoParkingLot(Long numberOfSlots){
        for (int i=1; i<=this.numberOfFloors; i++){
            this.floorList.add(new Floor((long) i, numberOfSlots));
        }
    }

    public Slot findAvailableSlotInParkingLot(VehicleType vehicleType){
        Slot slot = null;
        for (Floor floor : this.floorList){
            slot = floor.findAvailableSlotOnFloor(vehicleType);
            if(Objects.nonNull(slot)) return slot;
        }
        return null;
    }

    public void displaySlots(SlotStatus queryType, VehicleType vehicleType){
        List <Long> querySlotList;
        for (Floor floor : this.floorList){
            System.out.println(queryType.name() + " slots on floor " + floor.getFloorNumber());
            querySlotList = floor.findSlotsOnFloor(queryType, vehicleType);
            for (Long slotNumber : querySlotList){
                System.out.print(slotNumber + " ");
            }
            System.out.println();
        }
    }

}
