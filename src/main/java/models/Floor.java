package models;

import Constants.SlotStatus;
import Constants.VehicleType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

@Data
public class Floor {
    private Long floorNumber;
    private Long numberOfSlots;
    private List <Slot> slotList;

    public Floor(Long floorNumber, Long numberOfSlots){
        this.floorNumber = floorNumber;
        this.numberOfSlots = numberOfSlots;
        this.slotList = new ArrayList<>();
        allotSlotsToFloor();
    }

    private void allotSlotsToFloor(){
        for(int i=1; i<=this.numberOfSlots; i++){
            if(i==1) this.slotList.add(new Slot(VehicleType.TRUCK, (long) i, floorNumber));
            else if(i<=3) this.slotList.add(new Slot(VehicleType.BIKE, (long) i, floorNumber));
            else this.slotList.add(new Slot(VehicleType.CAR, (long) i, floorNumber));
        }
    }

    public Slot findAvailableSlotOnFloor(VehicleType vehicleType){
        for(Slot slot : this.slotList){
            if(slot.getVehicleType().equals(vehicleType) && slot.getStatus().equals(SlotStatus.FREE)){
                return slot;
            }
        }
        return null;
    }

    public List<Long> findSlotsOnFloor(SlotStatus queryType, VehicleType vehicleType){
        List <Long> querySlotList = new ArrayList<>();
        for(Slot slot : this.slotList){
            if(slot.getVehicleType().equals(vehicleType) && slot.getStatus().equals(queryType)){
                querySlotList.add(slot.getSlotNumber());
            }
        }
        return querySlotList;
    }

}
