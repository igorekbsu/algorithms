package contains_dup_II;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        Map<Integer, Integer> m = new HashMap<>(a.length);
        for (int i = 0; i < a.length; i++) {
            Integer j = m.put(a[i], i);
            if (j != null && i - j <= k)
                return true;
        }
        return false;
    }
}
