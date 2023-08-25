import Constants.SlotStatus;
import Constants.VehicleType;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import org.junit.Test;
import service.ParkingService;
import service.ParkingServiceImpl;

public class ParkingLotSystem {

    @Test
    public void driverClass(){
        ParkingLot parkingLot = new ParkingLot("PR1234", 5L, 10L);
        ParkingService parkingService = new ParkingServiceImpl(parkingLot);
        Ticket ticket1 = parkingService.parkVehicle(new Vehicle(VehicleType.CAR, "KA99", "Black"));
        Ticket ticket2 = parkingService.parkVehicle(new Vehicle(VehicleType.CAR, "KA99", "White"));
        parkingLot.displaySlots(SlotStatus.FREE, VehicleType.CAR);
        parkingService.unparkVehicle(ticket1);
        parkingLot.displaySlots(SlotStatus.FREE, VehicleType.CAR);
        Ticket ticket3 = parkingService.parkVehicle(new Vehicle(VehicleType.CAR, "KA99", "Blue"));
    }

}
