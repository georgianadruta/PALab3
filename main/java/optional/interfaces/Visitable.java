package optional.interfaces;

import optional.visiting.Duration;

import java.time.LocalTime;

/**
 * Interface that implements an opening time and a closing time
 */
public interface Visitable {

    /**
     * default method with the opening hour 09:30
     */
    public default LocalTime setOpeningTime() {
        return LocalTime.of(9, 30, 0);
    }

    /**
     * default method with the closing hour 20:00.
     */
    public default LocalTime setClosingTime() {
        return LocalTime.of(20, 0, 0);
    }

    /**
     * static method getVisitingDuration,in the interface Visitable, that returns a Duration object, representing how long a location is opened during a day.
     */
    static Duration getVisitingDuration(LocalTime openingTime, LocalTime closingTime) {
        return new Duration(openingTime, closingTime);
    }

    LocalTime getOpeningTime();

    LocalTime getClosingTime();
}
