package si.unilj.fri.vss.aps2.seminar3;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public final class MinRechargeCalculator {
    public static int calculate(Trip trip) {
        int time = trip.time; 
        int charge = trip.initialCharge;
        List<Stop> stops = trip.stops;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0, prev = 0;
        
        for (Stop stop: stops) {
            int stopTime = stop.time;
            int stopCharge = stop.batteryRecharge;
            charge -= stopTime - prev; 
            while(!pq.isEmpty() && charge <  0) {
                charge += pq.poll();
                ans++;
            }
            
            if (charge < 0) 
                return -1;
            
            pq.offer(stopCharge);
            prev = stopTime;      
        }
        
        {
            charge -= time - prev;
            while (!pq.isEmpty() && charge < 0) {
                charge += pq.poll();
                ans++;
            }
            
            if (charge < 0) 
                return -1;
        }
        
        return ans;
    }
}
