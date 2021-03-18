package bonus;

import optional.locations.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of days available to visit the city.");
        int numberDays = input.nextInt();
        while (numberDays < 0) {
            System.out.println("The number is not an integer! Enter a new number.");
            numberDays = input.nextInt();
        }

        System.out.println("Enter the number of minutes available for visiting.");
        int numberMinutes = input.nextInt();
        while (numberMinutes < 0) {
            System.out.println("The number is not an integer! Enter a new number.");
            numberMinutes = input.nextInt();
        }

        //Create the instance of the problem described in the example.
        Location v1 = new Hotel("Hotel Ritz Paris", "09:00:00", "23:00:00", 5, 500.00);
        Location v2 = new Museum("The Louvre Museum ", "10:00:00", "18:00:00", 5, 120.00);
        Location v3 = new Museum("Picasso Museum", "09:00:00", "18:00:00", 4, 89.50);
        Location v4 = new Church("Notre-Dame de Paris Cathedral", "08:00:00", "22:00:00", 5);
        Location v5 = new Church("Church of Saint-Eustache", "06:00:00", "17:00:00", 3);
        Location v6 = new Restaurant("Le Jules Verne Restaurant", "09:00:00", "23:00:00", 5, 100);

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
        v5.setCost(v1, 10);

        // Create the city Paris and add the above locations to it
        City Paris = new City();
        Paris.addLocation(v1);
        Paris.addLocation(v2);
        Paris.addLocation(v3);
        Paris.addLocation(v4);
        Paris.addLocation(v5);
        Paris.addLocation(v6);

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(v1);
        locations.add(v2);
        locations.add(v3);
        locations.add(v4);
        locations.add(v5);
        locations.add(v6);

        // create a plan starting with v1
        Itinerary itinerary = new Itinerary(Paris, locations, numberDays, numberMinutes);
        itinerary.searchPath(v1);
    }
}

