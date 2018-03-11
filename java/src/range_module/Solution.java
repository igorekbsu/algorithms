package range_module;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        RangeModule r = new RangeModule();
        r.addRange(3, 5);
        System.out.println(r.queryRange(1, 4));
    }

    static class RangeModule {
        TreeMap<Integer, Integer> m = new TreeMap<>();

        public void addRange(int left, int right) {
            Integer lo = m.floorKey(left), hi = m.floorKey(right);
            if (lo == null && hi == null)
                m.put(left, right);
            else if (lo != null && m.get(lo) >= left)
                m.put(lo, Math.max(m.get(hi), Math.max(m.get(lo), right)));
            else m.put(left, Math.max(m.get(hi), right));
            m.subMap(left, false, right, true).clear();
        }

        public boolean queryRange(int left, int right) {
            Integer start = m.floorKey(left);
            return start != null && m.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            Integer lo = m.floorKey(left), hi = m.floorKey(right);
            if (hi != null && m.get(hi) > right)
                m.put(right, m.get(hi));
            if (lo != null && m.get(lo) > left)
                m.put(lo, left);
            m.subMap(left, true, right, false).clear();
        }
    }
}
