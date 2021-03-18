package compulsory.locations;

import compulsory.Location;
import compulsory.interfaces.Classifiable;
import compulsory.interfaces.Visitable;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Class Church creates a location with the name of the church and a cost map from church to other locations.
 * It is visitable with opening hour and closing hour and classifiable with a rank between 0 and 10.
 */
public class Church extends Location implements Visitable, Classifiable {

    private LocalTime openingTime, closingTime;
    private double rank;

    // constructors

    /**
     * @param name        name of the church
     * @param openingTime When the visit program begins
     * @param closingTime and when it ends
     * @param rank        between 0 and 10, if the rank is not valid will display a error
     */
    public Church(String name, LocalTime openingTime, LocalTime closingTime, double rank) {
        super(name, new HashMap<>());
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        if (rank > 0 && rank <= 10)
            this.rank = rank;
        else
            System.err.println("Invalid rank.");
    }

    /**
     * @param name        name of the church
     * @param openingTime When the visit program begins. The parameter is a string and will be convert to LocalTime if the hour is valid
     * @param closingTime and when it ends. The same process
     * @param rank        between 0 and 10, if the rank is not valid will display a error
     */
    public Church(String name, String openingTime, String closingTime, int rank) {
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
    }

    //getters
    @Override
    public LocalTime getOpeningTime() {
        return this.openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return this.closingTime;
    }

    @Override
    public double getRank() {
        return this.rank;
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
}