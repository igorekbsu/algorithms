package four_sum_II;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int a : A)
            for (int b : B)
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);
        int count = 0;
        for (int c : C)
            for (int d : D)
                count += m.getOrDefault(-c - d, 0);
        return count;
    }
}
