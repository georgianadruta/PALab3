package optional.locations;

import optional.interfaces.Classifiable;
import optional.interfaces.Visitable;

import java.time.LocalTime;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Location class implements visitable and classifiable interfaces because I consider each location is visitable and classifiable
 * in order to simplify the code.
 */
public abstract class Location implements Comparable<Location>, Visitable, Classifiable {
    private String name;
    private double rank;
    private Map<Location, Integer> cost;
    private LocalTime openingTime, closingTime;

    //constructors
    public Location() {
        this.name = "Default name";
        this.rank = 10;
    }

    /**
     * @param name        name of the location
     * @param cost        the time (in minutes) required to go from the current location location to another
     * @param openingTime when is visitable the location (type LocalTime)
     * @param closingTime when the visiting schedule ends (type LocalTime)
     * @param rank        a number>0 and <=10.
     */
    public Location(String name, Map<Location, Integer> cost, LocalTime openingTime, LocalTime closingTime, double rank) {
        this.name = name;
        this.cost = cost;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        if (rank >= 0 && rank <= 10)
            this.rank = rank;
        else
            System.err.println("Invalid rank.");
    }

    /**
     * @param name        name of the location
     * @param cost        the time (in minutes) required to go from the current location location to another
     * @param openingTime when is visitable the location (type String)
     * @param closingTime when the visiting schedule ends (type String)
     * @param rank        a number>0 and <=10.
     */
    public Location(String name, Map<Location, Integer> cost, String openingTime, String closingTime, double rank) {
        this.name = name;
        this.cost = cost;
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

    // getters
    public String getName() {
        return this.name;
    }

    public Map<Location, Integer> getCost() {
        return this.cost;
    }

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
    public void setName(String name) {
        if (name != null)
            this.name = name;
        else
            System.err.println("Invalid name.");
    }

    public void setCost(Location location, int value) {
        if (value > 0) {
            this.cost.put(location, value);
        } else
            System.err.println("Invalid cost.");
    }

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

    @Override
    public void setRank(double rank) {
        if (rank >= 0 && rank <= 10)
            this.rank = rank;
        else
            System.err.println("Invalid rank.");
    }

    /**
     * check if an string given as parameter is a valid hour
     *
     * @param time an string of form "hh:mm:ss"
     * @return true if the time is valid, else false
     */
    private boolean checkTime(String time) {
        Pattern p = Pattern.compile(".*([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9].*");
        Matcher m = p.matcher(time);
        return m.matches();
    }

    /**
     * display cost map from each locations to other locations.
     */
    public void displayCost() {
        for (Map.Entry<Location, Integer> entry : this.cost.entrySet()) {
            System.out.print(this.getName() + " -> ");
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
    }

    /**
     * helpful method for compareTo method
     * compute the total seconds from openingTime
     *
     * @return number of seconds
     */
    private int time() {
        int seconds = this.getOpeningTime().getHour() * 3600 + this.getOpeningTime().getMinute() * 60 + this.getOpeningTime().getSecond();
        return seconds;
    }

    /**
     * helpful method to order the list of locations by openingTime.
     *
     * @param location another location
     * @return 1 if this.openingTime>location.openingTime, 0 if this.openingTime=location.openingTime else -1.
     */
    @Override
    public int compareTo(Location location) {
        int currTime = this.time();
        int anotherTime = location.time();
        return Integer.compare(currTime, anotherTime);
    }

    /**
     * Display a message representing how long a location is opened during a day.
     */
    public void showVisitingDuration() {
        System.out.println(new StringBuilder().append("The location ").append(this.getName()).append(" is opening for ").append(Visitable.getVisitingDuration(this.getOpeningTime(), this.getClosingTime()).getDuration()).append(" hours").toString());
    }

}
