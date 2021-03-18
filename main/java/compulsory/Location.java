package compulsory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Location implements Comparable<Location> {
    private String name;
    private final Map<Location, Integer> cost;

    //constructors
    public Location(String name, HashMap<Location, Integer> cost) {
        this.name = name;
        this.cost = cost;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public Map<Location, Integer> getCost() {
        return this.cost;
    }

    // setters. If data is valid then assign the values, else display an error
    public void setName(String name) {
        if (name != null)
            this.name = name;
        else
            System.err.println("Invalid name.");
    }

    public void setCost(Location location, int value) {
        if (value > 0)
            this.cost.put(location, value);
        else
            System.err.println("Invalid cost.");
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + this.name + '\'' +
                ", cost=" + this.cost +
                '}';
    }

    /**
     * Used for sorting in ascending order of roll name using comparable interface
     */
    @Override
    public int compareTo(Location other) {
        if (other.getName() != null && !other.getName().isEmpty())
            return this.name.compareTo(other.name);
        else
            throw new NullPointerException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(cost, location.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    /**
     * check if a string given as parameter is a valid hour
     *
     * @param time a string of form "hh:mm:ss"
     * @return true if the time is valid, else false
     */
    protected boolean checkTime(String time) {
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
}
