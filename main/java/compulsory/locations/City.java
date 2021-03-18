package compulsory.locations;

import compulsory.Location;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Class City create a list with the locations from the current city
 */
public class City implements Comparator<Location> {
    private List<Location> locations;

    //constructors
    public City() {
        locations = new LinkedList<>();
    }

    public City(List<Location> locations) {
        this.locations = locations;
    }

    //getters
    public List<Location> getLocationsList() {
        return this.locations;
    }

    //setters
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * add a location given as parameter to the list of locations
     *
     * @param location a new location to add
     */
    public void addLocation(Location location) {
        locations.add(location);
    }

    @Override
    public String toString() {
        return "City{" +
                "locations=" + locations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(locations, city.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations);
    }

    /**
     * Used for sorting in ascending order of roll name using comparator interface
     *
     * @param location first location
     * @param other second location
     * @return true if the locations are the same. false if the locations are not the same. exception if a location have a name=null
     */
    public int compare(Location location, Location other) {
        if (other.getName() != null && !other.getName().isEmpty())
            return location.getName().compareTo(other.getName());
        else
            throw new NullPointerException();
    }
}
