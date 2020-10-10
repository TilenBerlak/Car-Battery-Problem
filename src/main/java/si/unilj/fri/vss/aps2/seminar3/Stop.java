package si.unilj.fri.vss.aps2.seminar3;

import java.util.Scanner;

/**
 * Class representing a stop where a battery can be recharged.
 */
public final class Stop {
    /**
     * Time to reach this stop.
     */
    final int time;

    /**
     * The amount a battery can be recharged.
     */
    final int batteryRecharge;

    public Stop(final int time, final int batteryRecharge) {
        this.time = time;
        this.batteryRecharge = batteryRecharge;
    }

    /**
     * A factory method to construct an instance of this class by parsing input
     * from scanner.
     * @param scanner tokenized input provider 
     * @return A new instance of this class as read from the scanner
     */
    public static Stop parse(final Scanner scanner) {
        final int time = scanner.nextInt();
        final int recharge = scanner.nextInt();
        return new Stop(time, recharge);
    }
}
