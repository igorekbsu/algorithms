package train;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] a) {
        int majority = 0, maxCount = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int e : a) {
            m.put(e, m.getOrDefault(e, 0) + 1);
            if (m.get(e) > maxCount) {
                maxCount = m.get(e);
                majority = e;
            }
        }
        return majority;
    }
}
