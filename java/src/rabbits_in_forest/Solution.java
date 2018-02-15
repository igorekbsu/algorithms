package rabbits_in_forest;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numRabbits(new int[]{1, 1, 2}));
    }

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int a : answers)
            counts.put(a, counts.getOrDefault(a, 0) + 1);
        int N = 0;
        for (Integer n : counts.keySet())
            N += (counts.get(n) + n) / (n + 1) * (n + 1);
        return N;
    }
}
