package coin_change;
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++)
            dp[i] = amount + 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
