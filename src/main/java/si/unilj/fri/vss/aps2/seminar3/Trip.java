package si.unilj.fri.vss.aps2.seminar3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class representing the whole trip. 
 * The trip is described by the total trip time, the initial charge
 * of the battery and zero or more stops, assumed to be chronologically
 * ordered with respect to the time.
 */
public final class Trip {
    /**
     * The total time of this trip.
     */
    final int time;

    /**
     * The amount the battery is initially charged.
     */
    final int initialCharge;

    /**
     * The list of stops on the trip, where it is possible
     * to recharge the battery.
     */
    final List<Stop> stops;

    public Trip(final int time, final int initialCharge) {
        this(time, initialCharge, new ArrayList<Stop>());
    }

    public Trip(final int time, final int initialCharge, List<Stop> stops) {
        this.time = time;
        this.initialCharge = initialCharge;
        this.stops = stops;
    }

    /**
     * A factory method to construct this object from a scanner instance.
     * @param scanner An input tokenizer
     * @return A new instance of this class, as represented by the input
     */
    public static Trip parse(final Scanner scanner) {
        final int time = scanner.nextInt();
        final int initialCharge = scanner.nextInt();
        final int n = scanner.nextInt();
        List<Stop> stops = new ArrayList<>(n);

        int stTime = 0;
        for (int i = 0; i < n; i++) {
            stops.add(Stop.parse(scanner));
            assert stops.get(i).time > stTime;
            stTime = stops.get(i).time;
        }
        if (! stops.isEmpty()) {
            assert time > stops.get(stops.size() - 1).time;
        }
        
        return new Trip(time, initialCharge, stops);
    }
  
}
