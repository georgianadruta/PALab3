package optional.visiting;

import java.time.LocalTime;

public class Duration {
    private LocalTime duration;

    /**
     * constructor
     * variable duration represent how long a location is opened during a day.
     * calculate the duration of the visit by subtracting openingTime from closingTime
     *
     * @param openingTime opening time for a location
     * @param closingTime closing time for a location
     */
    public Duration(LocalTime openingTime, LocalTime closingTime) {
        int hoursDiff = closingTime.getHour() - openingTime.getHour();
        int minutesDiff = closingTime.getMinute() - openingTime.getMinute();
        int secondsDiff = closingTime.getSecond() - openingTime.getSecond();

        if (secondsDiff < 0) {
            secondsDiff += 60;
            minutesDiff--;
        }
        if (minutesDiff < 0) {
            minutesDiff += 60;
            hoursDiff--;
        }
        if (hoursDiff < 0) {
            hoursDiff += 24;
        }
        this.duration = LocalTime.of(hoursDiff, minutesDiff, secondsDiff);
    }

    //setter
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    //getter
    public LocalTime getDuration() {
        return duration;
    }
}
