package employee_free_time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import nub.Nu.Interval;

public class Solution {
    public static void main(String[] args) {
        List<List<Interval>> list = Arrays.asList(
            Arrays.asList(new Interval(7, 24), new Interval(29, 33)),
            Arrays.asList(new Interval(6, 24), new Interval(43, 49)),
            Arrays.asList(new Interval(9, 16), new Interval(27, 35)),
            Arrays.asList(new Interval(5, 16), new Interval(18,26)),
            Arrays.asList(new Interval(0, 25), new Interval(29, 31))
        );
        System.out.println(new Solution().employeeFreeTime(list));
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeSet<Interval> set = new TreeSet<>(new Comparator<Interval>() {
            @Override public int compare(Interval o1, Interval o2) {
                return o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end;
            }
        });
        for (List<Interval> intervals : schedule)
            set.addAll(intervals);
        List<Interval> r = new LinkedList<>();
        int endTime = set.first().end;
        for (Interval i : set) {
            if (endTime < i.start)
                r.add(new Interval(endTime, i.start));
            endTime = Math.max(i.end, endTime);
        }
        return r;
    }
}
