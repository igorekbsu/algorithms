package split_array_into_consecutive_subsequences;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{1,2,3,4,4,5}));
    }

    public boolean isPossible(int[] a) {
        Map<Integer, Integer> f = new HashMap<>(), seqs = new HashMap<>();
        for (int n : a)
            f.put(n, f.getOrDefault(n, 0) + 1);
        for (int n : a) {
            if (f.get(n) == 0)
                continue;
            else if (seqs.getOrDefault(n, 0) > 0) {
                seqs.put(n + 1, seqs.getOrDefault(n + 1, 0) + 1);
                seqs.put(n, seqs.get(n) - 1);
            } else if (f.getOrDefault(n + 1, 0) > 0 && f.getOrDefault(n + 2, 0) > 0) {
                f.put(n + 1, f.get(n + 1) - 1);
                f.put(n + 2, f.get(n + 2) - 1);
                seqs.put(n + 3, seqs.getOrDefault(n + 3, 0) + 1);
            } else return false;
            f.put(n, f.get(n) - 1);
        }
        return true;
    }
}
