package best_time_to_buy_and_sell_stock_IV;
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            return profit;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int max = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
                max = Math.max(max, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
