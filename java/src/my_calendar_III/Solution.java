package my_calendar_III;
import java.util.TreeMap;

public class Solution {
    class MyCalendarThree {
        final TreeMap<Integer, Integer> times = new TreeMap<>();

        public int book(int s, int e) {
            times.put(s, times.getOrDefault(s, 0) + 1);
            times.put(e, times.getOrDefault(e, 0) - 1);
            int maxBooked = 0, total = 0;
            for (Integer v : times.values())
                maxBooked = Math.max(maxBooked, total += v);
            return maxBooked;
        }
    }
}
