package find_anagrams_mappings;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < B.length; i++)
            m.put(B[i], i);
        int[] r = new int[A.length];
        for (int i = 0; i < A.length; i++)
            r[i] = m.get(A[i]);
        return r;
    }
}
