package random_pick_with_blacklist;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    final Map<Integer, Integer> m = new HashMap<>();
    final int M;
    int idx;

    public Solution(int n, int[] blacklist) {
        for (int i : blacklist)
            m.put(i, -1);
        M = n - m.size();
        for (int i : blacklist)
            if (i < M) {
                while (m.containsKey(n - 1))
                    n--;
                m.put(i, n-- - 1);
            }
    }

    public int pick() {
        int p = idx;
        idx = (idx + 1) % M;
        return m.getOrDefault(p, p);
    }
}
