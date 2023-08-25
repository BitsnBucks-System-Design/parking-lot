package models;

import lombok.Data;

@Data
public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private Slot slot;

    public Ticket(String ticketId, Vehicle vehicle, Slot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
    }
}
