package advantage_shuffle;
import java.util.TreeMap;

public class Solution {
    public int[] advantageCount(int[] a, int[] b) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int n : a)
            m.put(n, m.getOrDefault(n, 0) + 1);
        int[] r = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            Integer val = m.higherKey(b[i]);
            if (val == null)
                val = m.firstKey();
            m.put(val, m.get(val) - 1);
            if (m.get(val) == 0)
                m.remove(val);
            r[i] = val;
        }
        return r;
    }
}
