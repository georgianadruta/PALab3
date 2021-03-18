package compulsory;

import compulsory.locations.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Create the instance of the problem described in the example.
        Location v1 = new Hotel("Hotel Ritz Paris", "09:00:00", "23:00:00", 5, 500.00);
        Location v2 = new Museum("The Louvre Museum ", "10:00:00", "18:00:00", 5, 120.00);
        Location v3 = new Museum("Picasso Museum", "09:00:00", "18:00:00", 4, 89.50);
        Location v4 = new Church("Notre-Dame de Paris Cathedral", "08:00:00", "22:00:00", 5);
        Location v5 = new Church("Church of Saint-Eustache", "08:00:00", "22:00:00", 3);
        Location v6 = new Restaurant("Le Jules Verne Restaurant", "09:00:00", "23:00:00", 5);

        // Set the cost to the above locations
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v2, 20);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v4, 30);
        v5.setCost(v6, 20);

        // Print on the screen the instance of the problem described in the example.
        v1.displayCost();
        v2.displayCost();
        v3.displayCost();
        v4.displayCost();
        v5.displayCost();
        v6.displayCost();
        System.out.println();

        // Create the city Paris and add the above locations to it
        City Paris = new City();
        Paris.addLocation(v1);
        Paris.addLocation(v2);
        Paris.addLocation(v3);
        Paris.addLocation(v4);
        Paris.addLocation(v5);
        Paris.addLocation(v6);

        Location[] locations = new Location[]{v1, v2, v3, v4, v5, v6};

        System.out.println("Array before sorting is:");
        for (Location location : locations)
            System.out.println(location.getName());

        // Sort the array by name using comparator interface
        System.out.println();
        Arrays.sort(locations, new City());
        System.out.println("Array after sorting by name using comparator interface is:");
        for (Location location : locations)
            System.out.println(location.getName());

        // Sort the array by name using comparable interface
        locations = new Location[]{v1, v2, v3, v4, v5, v6};
        Arrays.sort(locations);
        System.out.println();
        System.out.println("Array after sorting by name using comparable interface is:");
        for (Location location : locations)
            System.out.println(location.getName());

    }
}

