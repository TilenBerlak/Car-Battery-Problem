package si.unilj.fri.vss.aps2.seminar3;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.List;

import org.junit.Test;

public class TripTest {
    private static final String NEW_LINE = System.lineSeparator();

    @Test
    public void testConstructor1() {
        Trip trip = new Trip(10, 5);

        assertEquals(10, trip.time);
        assertEquals(5, trip.initialCharge);
        assertEquals(0, trip.stops.size());
    }

    @Test
    public void testConstructor2() {
        Trip trip = new Trip(10, 5, List.of(new Stop(1, 2), new Stop(2, 3)));

        assertEquals(10, trip.time);
        assertEquals(5, trip.initialCharge);
        assertEquals(2, trip.stops.size());

        assertEquals(1, trip.stops.get(0).time);
        assertEquals(2, trip.stops.get(0).batteryRecharge);
        assertEquals(2, trip.stops.get(1).time);
        assertEquals(3, trip.stops.get(1).batteryRecharge);
    }
    
    @Test
    public void testParse1() {
        final Scanner scanner = new Scanner("100 1 0");
        final Trip trip = Trip.parse(scanner);

        assertEquals(100, trip.time);
        assertEquals(1, trip.initialCharge);
        assertEquals(0, trip.stops.size());
    }

    @Test
    public void testParse2() {
        final StringBuilder sb = new StringBuilder();
        sb.append("1000 5 1");
        sb.append(NEW_LINE);
        sb.append("23 67");

        final Scanner scanner = new Scanner(sb.toString());
        final Trip trip = Trip.parse(scanner);

        assertEquals(1000, trip.time);
        assertEquals(5, trip.initialCharge);
        assertEquals(1, trip.stops.size());

        assertEquals(23, trip.stops.get(0).time);
        assertEquals(67, trip.stops.get(0).batteryRecharge);
    }

    @Test
    public void testParse3() {
        final StringBuilder sb = new StringBuilder();
        sb.append("1000000 4 1");
        sb.append(NEW_LINE);
        sb.append("23 67");
        sb.append(NEW_LINE);

        final Scanner scanner = new Scanner(sb.toString());
        final Trip trip = Trip.parse(scanner);

        assertEquals(1_000_000, trip.time);
        assertEquals(4, trip.initialCharge);
        assertEquals(1, trip.stops.size());

        assertEquals(23, trip.stops.get(0).time);
        assertEquals(67, trip.stops.get(0).batteryRecharge);
    }

    @Test
    public void testParse4() {
        final StringBuilder sb = new StringBuilder();
        sb.append("1000000 4 3");
        sb.append(NEW_LINE);
        sb.append("23 67");
        sb.append(NEW_LINE);
        sb.append("45 89");
        sb.append(NEW_LINE);
        sb.append("56 91");
        sb.append(NEW_LINE);

        final Scanner scanner = new Scanner(sb.toString());
        final Trip trip = Trip.parse(scanner);
        
        assertEquals(1_000_000, trip.time);
        assertEquals(4, trip.initialCharge);
        assertEquals(3, trip.stops.size());

        assertEquals(23, trip.stops.get(0).time);
        assertEquals(67, trip.stops.get(0).batteryRecharge);
        assertEquals(45, trip.stops.get(1).time);
        assertEquals(89, trip.stops.get(1).batteryRecharge);
        assertEquals(56, trip.stops.get(2).time);
        assertEquals(91, trip.stops.get(2).batteryRecharge);
    }
}