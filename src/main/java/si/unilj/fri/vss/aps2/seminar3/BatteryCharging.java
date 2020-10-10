package si.unilj.fri.vss.aps2.seminar3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Main class and application entry point.
 */
public final class BatteryCharging
{
    public static void main( String[] args )
    {
        Trip trip = Trip.parse(new Scanner(new BufferedReader(new InputStreamReader(System.in))));
        int result = MinRechargeCalculator.calculate(trip);

        System.out.println(result);
    }
}
