package bonus;

import optional.locations.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ItineraryTest {

    @Test
    void searchPath() {
        Location v1 = new Hotel("Hotel Ritz Paris", "09:00:00", "23:00:00", 5, 500.00);
        Location v2 = new Museum("The Louvre Museum ", "10:00:00", "18:00:00", 5, 120.00);
        Location v3 = new Museum("Picasso Museum", "09:00:00", "18:00:00", 4, 89.50);
        Location v4 = new Church("Notre-Dame de Paris Cathedral", "08:00:00", "22:00:00", 5);
        Location v5 = new Church("Church of Saint-Eustache", "06:00:00", "17:00:00", 3);
        Location v6 = new Restaurant("Le Jules Verne Restaurant", "09:00:00", "23:00:00", 5, 100);
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
        City Paris = new City(Arrays.asList(v1, v2, v3, v4, v5, v6));
        Itinerary itinerary = new Itinerary(Paris, Arrays.asList(v1, v2, v3, v4, v5, v6), 1, 50);
        assertEquals(50, itinerary.searchPath(v1));
    }
}