package compulsory.locations;

import compulsory.Location;
import compulsory.interfaces.Classifiable;
import compulsory.interfaces.Payable;
import compulsory.interfaces.Visitable;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Class Hotel creates a location with the name of the hotel and a cost map from hotel to other locations.
 * It is visitable with opening and closing hour.
 * It is Classifiable with a rank between 0 and 10.
 * It is Payable with a ticket, ticketPrice > 0.
 */
public class Hotel extends Location implements Payable, Visitable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    private double rank;

    // constructors

    /**
     * @param name        name of the hotel
     * @param openingTime When the visit program begins
     * @param closingTime and when it ends
     * @param rank        a number between 0 and 10, if the number is not valid will display an error
     * @param ticketPrice a number bigger than 0, if the number is not valid will display an error
     */
    public Hotel(String name, LocalTime openingTime, LocalTime closingTime, double rank, double ticketPrice) {
        super(name, new HashMap<>());
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        if (rank >= 0 && rank <= 10)
            this.rank = rank;
        else
            System.err.println("Invalid rank.");
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
        else
            System.err.println("Invalid price.");
    }

    /**
     * @param name        name of the hotel
     * @param openingTime When the visit program begins. The parameter is a string and will be convert to LocalTime if the hour is valid
     * @param closingTime and when it ends. The same process
     * @param rank        a number between 0 and 10, if the number is not valid will display an error
     * @param ticketPrice a number bigger than 0, if the number is not valid will display an error
     */
    public Hotel(String name, String openingTime, String closingTime, double rank, double ticketPrice) {
        super(name, new HashMap<>());
        if (checkTime(openingTime) && checkTime(closingTime)) {
            this.openingTime = LocalTime.parse(openingTime);
            this.closingTime = LocalTime.parse(closingTime);
        } else
            System.err.println("Invalid time.");
        if (rank >= 0 && rank <= 10)
            this.rank = rank;
        else
            System.err.println("Invalid rank.");
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
        else
            System.err.println("Invalid price.");
    }

    //getters
    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public double getRank() {
        return this.rank;
    }

    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    // setters. If data is valid then assign the values, else display an error
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setClosingTime(String closingTime) {
        if (checkTime(closingTime))
            this.openingTime = LocalTime.parse(closingTime);
        else
            System.err.println("Invalid time.");
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setOpeningTime(String openingTime) {
        if (checkTime(openingTime))
            this.openingTime = LocalTime.parse(openingTime);
        else
            System.err.println("Invalid time.");
    }

    public void setRank(double rank) {
        if (rank >= 0 && rank <= 10)
            this.rank = rank;
        else
            System.err.println("Invalid rank.");
    }

    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
        else
            System.err.println("Invalid price.");
    }
}

