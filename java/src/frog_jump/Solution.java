package frog_jump;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12}));
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        int[][] dp = new int[stones.length][stones.length];
        Set<Integer> s = new HashSet<>();
        for (int stone : stones)
            s.add(stone);
        return canCross(1, 1, stones, s, dp);
    }

    boolean canCross(int i, int k, int[] stones, Set<Integer> s, int[][] dp) {
        if (i >= stones.length)
            return false;
        if (i == stones.length - 1)
            return true;
        if (dp[i][k] != 0)
            return dp[i][k] == 1;
        for (int step = k - 1; step <= k + 1; step++) {
            int j = i + step;
            if (s.contains(stones[i] + k + step) && j > i)
                if (canCross(j, k + step, stones, s, dp))
                    return true;
        }
        dp[i][k] = -1;
        return false;
    }
}
