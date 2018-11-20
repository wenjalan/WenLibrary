package wenjalan;

// a timer used to time the execution of a program
// has an accuracy of nanoseconds
public class Timer {

    // enum for timer units
    public enum Unit {

        // the units
        NANOSECOND(1D),
        MILLISECOND(1_000_000D),
        SECOND(1_000_000_000.0D);

        // the amount of units in a second
        private final double NANOSECONDS_PER_UNIT;

        // constructor
        Unit(double nanosPerUnit) {
            this.NANOSECONDS_PER_UNIT = nanosPerUnit;
        }

    }

    // the amount of nanoseconds in a second
    private final Unit unit;

    // the start timestamp
    private double startTime = -1;

    // default constructor
    public Timer() {
        this(Unit.NANOSECOND);
    }

    // full constructor
    public Timer(Unit unit) {
        this.unit = unit;
    }

    // returns the time
    private double time() {
        return System.nanoTime();
    }

    // starts the timer
    public Timer start() {
        if (startTime != -1)
            throw new IllegalStateException("Timer has already been started");
        this.startTime = time();
        return this;
    }

    // resets the timer, setting the starting time to now
    public Timer reset() {
        startTime = -1;
        return start();
    }

    // laps the timer, returning the elapsed time between the start and now
    public double lap() {
        if (startTime == -1)
            throw new IllegalStateException("Timer has not been started");
        return (time() - startTime) / unit.NANOSECONDS_PER_UNIT;
    }

}
