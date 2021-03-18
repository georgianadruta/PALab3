package optional;

import optional.locations.*;
import optional.visiting.ShortestPath;
import optional.visiting.TravelPlan;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

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

        // Print on the screen the instance of the problem described in the example.
        System.out.println("From    ->  to  | Cost");
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

        System.out.println("The locations that are visitable and are not payable, sorted by their opening hour are:");
        Paris.isVisitableNotPayable();

        // display an message representing how long v1 location is opened during a day
        v1.showVisitingDuration();
        v2.showVisitingDuration();
        v3.showVisitingDuration();
        v4.showVisitingDuration();
        v5.showVisitingDuration();
        v6.showVisitingDuration();

        // create the preference list
        ArrayList<Location> locationList = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5, v6));
        TravelPlan travelPlan = new TravelPlan(locationList);
        travelPlan.addPreference(v2, 3);
        travelPlan.addPreference("Picasso Museum", 2);
        travelPlan.updatePreference(v2, 0);
        travelPlan.addPreference(v1, 2);
        travelPlan.addPreference(v4, 1);
        travelPlan.addPreference(v5, 5);
        travelPlan.addPreference(v6, 4);

        // show the preferences order by importance
        travelPlan.displayPreferences();

        // compute and display the shortest path between two locations from the same city
        ShortestPath shortestPath = new ShortestPath(locationList, travelPlan.getPreferenceList());
        shortestPath.getMinDistance(v1, v5);
    }
}

