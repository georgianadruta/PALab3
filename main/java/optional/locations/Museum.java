package optional.locations;

import optional.interfaces.Payable;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Class Museum creates a location with the name of the hotel and a cost map from museum to other locations.
 * It is Payable with an ticket, ticketPrice > 0.
 */

public class Museum extends Location implements Payable {
    private double ticketPrice;

    // constructors

    /**
     * @param name        name of the hotel
     * @param openingTime When the visit program begins
     * @param closingTime and when it ends
     * @param rank        a number between 0 and 10, if the number is not valid will display an error
     * @param ticketPrice a number bigger than 0, if the number is not valid will display an error
     */
    public Museum(String name, LocalTime openingTime, LocalTime closingTime, double rank, double ticketPrice) {
        super(name, new HashMap<>(), openingTime, closingTime, rank);
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
        else
            System.err.println("Invalid price.");
    }

    /**
     * @param name        name of the hotel
     * @param openingTime When the visit program begins. The parameter is an string and will be convert to LocalTime if the hour is valid
     * @param closingTime and when it ends. The same process
     * @param rank        a number between 0 and 10, if the number is not valid will display an error
     * @param ticketPrice a number bigger than 0, if the number is not valid will display an error
     */
    public Museum(String name, String openingTime, String closingTime, double rank, double ticketPrice) {
        super(name, new HashMap<>(), openingTime, closingTime, rank);
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
        else
            System.err.println("Invalid price.");
    }

    //getter

    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    // setter. If data is valid then assign the values, else display an error

    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
        else
            System.err.println("Invalid price.");
    }
}