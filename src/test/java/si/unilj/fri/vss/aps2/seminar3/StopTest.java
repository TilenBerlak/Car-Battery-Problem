package si.unilj.fri.vss.aps2.seminar3;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class StopTest 
{
    @Test
    public void testConstructor1() {
        Stop stop = new Stop(1, 2);

        assertEquals(1, stop.time);
        assertEquals(2, stop.batteryRecharge);
    }

    @Test
    public void testParse()
    {
        Scanner scanner = new Scanner("12 34");
        Stop stop = Stop.parse(scanner);
        
        assertEquals(12, stop.time);
        assertEquals(34, stop.batteryRecharge);
    }
}
