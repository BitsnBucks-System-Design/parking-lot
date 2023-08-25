package models;

import Constants.VehicleType;
import lombok.Data;
@Data
public class Vehicle {
    private VehicleType vehicleType;
    private String regNumber;
    private String colour;

    public Vehicle(VehicleType vehicleType, String regNumber, String colour) {
        this.vehicleType = vehicleType;
        this.regNumber = regNumber;
        this.colour = colour;
    }
}
