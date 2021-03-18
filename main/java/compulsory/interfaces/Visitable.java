package compulsory.interfaces;

import java.time.LocalTime;

/**
 * Interface that implements an opening time and a closing time
 */
public interface Visitable {

    LocalTime getOpeningTime();
    LocalTime getClosingTime();
}
