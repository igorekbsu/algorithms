package interval;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> r = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            r.add(intervals.get(i++));
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end)
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i++).end));
        r.add(newInterval);
        while (i < intervals.size())
            r.add(intervals.get(i++));
        return r;
    }

    public class Interval {
        int start;
        int end;

        Interval() { start = 0; end = 0; }

        Interval(int s, int e) { start = s; end = e; }

    }
}