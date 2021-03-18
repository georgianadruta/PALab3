package optional.visiting;

import optional.locations.City;
import optional.locations.Location;

import java.util.*;

public class TravelPlan {
    private City city;
    private List<Location> locations;
    private Map<String, Integer> preferenceList = new HashMap<>(); // the order of preference is given by value

    // constructors

    /**
     * constructor
     *
     * @param locations an ArrayList with all the location
     */
    public TravelPlan(ArrayList<Location> locations) {
        this.city = new City();
        this.locations = locations;
    }

    // setters

    public void setCity(City city) {
        this.city = city;
    }

    public void setPreferenceList(Map<String, Integer> preferenceList) {
        this.preferenceList = new HashMap<>(preferenceList);
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    // getters

    public City getCity() {
        return this.city;
    }

    public Map<String, Integer> getPreferenceList() {
        return this.preferenceList;
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    /**
     * method to add a new preference with a order number
     * check if the location is in the current city and is not found in the preference list and order number is a positive integer
     *
     * @param location new location to add in the preferenceList
     * @param order    order number, location is among the most important preferences if it has the order number as low as possible
     */
    public void addPreference(Location location, int order) {
        if (order >= 0 && !preferenceList.containsKey(location.getName()) && locations.contains(location)) {
            preferenceList.put(location.getName(), order);
        } else {
            System.err.println("Invalid arguments.");
        }
    }

    /**
     * helpful method to check if a given string if it's the name of a location in the current city
     * search the string in the locations array
     *
     * @param location the name of location
     * @return true if the location is found, else false
     */
    public boolean foundLocation(String location) {
        for (Location value : locations) {
            if (Objects.equals(value.getName(), location)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method to add a new preference with a order number
     * check if the location is in the current city and is not found in the preference list and order number is a positive integer
     *
     * @param location new name of location to add in the preferenceList
     * @param order    order number, location is among the most important preferences if it has the order number as low as possible
     */
    public void addPreference(String location, int order) {
        if (order >= 0 && !preferenceList.containsKey(location) && foundLocation(location)) {
            preferenceList.put(location, order);
        } else {
            System.err.println("Not found the location " + location);
        }
    }

    /**
     * the preference list will be updated
     *
     * @param location a location from the preferenceList
     * @param order    the new order number
     */
    public void updatePreference(Location location, int order) {
        if (order >= 0 && preferenceList.containsKey(location.getName())) {
            preferenceList.put(location.getName(), order);
        }
    }

    /**
     * display preferenceList
     */
    public void displayPreferences() {
        System.out.println();
        System.out.println("The preference list is:");
        for (int order = 0; order < locations.size(); order++) {
            for (Map.Entry<String, Integer> location : preferenceList.entrySet()) {
                if (location.getValue() == order) {
                    System.out.println(location.getValue() + " " + location.getKey());
                }
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelPlan that = (TravelPlan) o;
        return Objects.equals(city, that.city) && Objects.equals(locations, that.locations) && Objects.equals(preferenceList, that.preferenceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, locations, preferenceList);
    }
}
