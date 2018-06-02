package merge_intervals;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.Interval;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals)
            if (merged.isEmpty() || merged.getLast().end < interval.start)
                merged.add(interval);
            else merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        return merged;
    }
}
