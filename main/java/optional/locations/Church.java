package optional.locations;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Class Church creates a location with the name of the church and a cost map from church to other locations.
 */
public class Church extends Location {

    // constructors

    /**
     * @param name        name of the church
     * @param openingTime When the visit program begins
     * @param closingTime and when it ends
     * @param rank        between 0 and 10, if the rank is not valid will display a error
     */
    public Church(String name, LocalTime openingTime, LocalTime closingTime, double rank) {
        super(name, new HashMap<>(), openingTime, closingTime, rank);
    }

    /**
     * @param name        name of the church
     * @param openingTime When the visit program begins. The parameter is a string and will be convert to LocalTime if the hour is valid
     * @param closingTime and when it ends. The same process
     * @param rank        between 0 and 10, if the rank is not valid will display a error
     */
    public Church(String name, String openingTime, String closingTime, int rank) {
        super(name, new HashMap<>(), openingTime, closingTime, rank);
    }
}