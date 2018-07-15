package min_number_of_refueling_stops;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> q = new PriorityQueue<>();
        long dist = startFuel;
        int r = 0, i = 0;
        while (true) {
            while (i < stations.length && stations[i][0] <= dist)
                q.offer(-stations[i++][1]);
            if (dist >= target) return r;
            if (q.isEmpty()) return -1;
            dist -= q.poll();
            r++;
        }
    }
}
