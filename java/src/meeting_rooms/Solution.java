package meeting_rooms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import nub.Nu.Interval;

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        PriorityQueue<Interval> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        q.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = q.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else
                q.offer(intervals[i]);
            q.offer(interval);
        }
        return q.size();
    }
}
