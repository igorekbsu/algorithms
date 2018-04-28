package non_overlapping_intervals;
import java.util.Arrays;
import java.util.Comparator;
import nub.Nu.Interval;

public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int count = 0, lastEnd = intervals[0].start;
        for (Interval interval : intervals)
            if (interval.start < lastEnd) {
                count++;
                lastEnd = Math.min(lastEnd, interval.end);
            } else lastEnd = interval.end;
        return count;
    }
}
