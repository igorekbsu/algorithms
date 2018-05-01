package contains_dup_III;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {
        TreeMap<Long, Integer> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            Long k1 = m.ceilingKey((long) a[i] - t), k2 = m.floorKey((long) a[i] + t);
            if (k1 != null && k1 <= a[i] && m.get(k1) != i && i - m.get(k1) <= k)
                return true;
            if (k2 != null && k2 >= a[i] && m.get(k2) != i && i - m.get(k2) <= k)
                return true;
            m.put((long) a[i], i);
        }
        return false;
    }
}
