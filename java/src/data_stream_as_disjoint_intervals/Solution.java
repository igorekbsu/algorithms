package data_stream_as_disjoint_intervals;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import nub.Nu.Interval;

public class Solution {
    class SummaryRanges {
        final TreeMap<Integer, Interval> tree = new TreeMap<>();

        public void addNum(int val) {
            if (tree.containsKey(val)) return;
            Integer lo = tree.lowerKey(val), hi = tree.higherKey(val);
            if (lo != null && hi != null && tree.get(lo).end + 1 == val && hi == val + 1) {
                tree.get(lo).end = tree.get(hi).end;
                tree.remove(hi);
            } else if (lo != null && tree.get(lo).end + 1 >= val)
                tree.get(lo).end = Math.max(tree.get(lo).end, val);
            else if (hi != null && hi == val + 1) {
                tree.put(val, new Interval(val, tree.get(hi).end));
                tree.remove(hi);
            } else tree.put(val, new Interval(val, val));
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(tree.values());
        }
    }
}
