package stone_game;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().stoneGame(new int[]{1, 10, 3}));
    }

    public boolean stoneGame(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length); ;
        for (int d = 1; d < p.length; d++)
            for (int i = 0; i < p.length - d; i++)
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
        return dp[0] > 0;
    }
}
                    