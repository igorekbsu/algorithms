package find_right_interval;
import java.util.TreeMap;
import nub.Nu.Interval;

public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int[] r = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++)
            m.put(intervals[i].start, i);
        for (int i = 0; i < intervals.length; i++) {
            Integer key = m.ceilingKey(intervals[i].end);
            r[i] = key == null ? -1 : m.get(key);
        }
        return r;
    }
}
