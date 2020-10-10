package si.unilj.fri.vss.aps2.seminar3;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class MinRechargeCalculatorTest {
    
    @Test
    public void testCase1() {
        Trip trip = new Trip(2, 2);
        
        int result = MinRechargeCalculator.calculate(trip);
        assertEquals(0, result);
    }

    @Test
    public void testCase2() {
        List<Stop> stops = List.of(
            new Stop(30, 300)
            );
        Trip trip = new Trip(300, 3, stops);        
        int result = MinRechargeCalculator.calculate(trip);
        assertEquals(-1, result);
    }

    @Test
    public void testCase3() {
        List<Stop> stops = List.of(
            new Stop(7, 42),
            new Stop(14, 21),
            new Stop(21, 21),
            new Stop(42, 28)
            );
        Trip trip = new Trip(70, 7, stops);        
        int result = MinRechargeCalculator.calculate(trip);
        assertEquals(2, result);
    }

    @Test
    public void testCase4() {
        List<Stop> stops = List.of(
            new Stop(5, 100),
            new Stop(997, 100),
            new Stop(998, 100)
            );
        Trip trip = new Trip(999, 1000, stops);       
        int result = MinRechargeCalculator.calculate(trip);
        assertEquals(0, result);
    }

    @Test
    public void testCase5() {
        List<Stop> stops = List.of(
            new Stop(125, 480),
            new Stop(162, 46),
            new Stop(175, 490),
            new Stop(194, 207),
            new Stop(355, 252),
            new Stop(369, 75),
            new Stop(433, 360),
            new Stop(553, 95),
            new Stop(562, 171),
            new Stop(566, 12)
            );
        Trip trip = new Trip(1000, 1, stops);
        
        int result = MinRechargeCalculator.calculate(trip);
        assertEquals(-1, result);
    }
}