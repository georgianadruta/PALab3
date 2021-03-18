package optional.locations;

import optional.interfaces.Payable;
import optional.interfaces.Visitable;

import java.util.*;

/**
 * Class City create a list with the locations from the current city
 */
public class City extends Location implements Comparable<Location> {
    protected List<Location> locations;

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

    public int getNumberLocations() {
        return locations.size();
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

    /**
     * display the locations that are visitable and are not payable, sorted ascending by their opening hour.
     */
    public void isVisitableNotPayable() {
        locations.removeIf(data -> data instanceof Payable || !(data instanceof Visitable));
        Collections.sort(locations);
        for (Location location : locations)
            System.out.println(location.getName());
        System.out.println();
    }
}
