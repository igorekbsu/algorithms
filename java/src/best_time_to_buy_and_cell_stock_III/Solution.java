package best_time_to_buy_and_cell_stock_III;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 3, 10}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit1 = 0, maxProfit2 = 0;
        int lowestBuyPrice1 = Integer.MAX_VALUE, lowestBuyPrice2 = Integer.MAX_VALUE;
        for (int p : prices) {
            maxProfit2 = Math.max(maxProfit2, p - lowestBuyPrice2);
            lowestBuyPrice2 = Math.min(lowestBuyPrice2, p - maxProfit1);
            maxProfit1 = Math.max(maxProfit1, p - lowestBuyPrice1);
            lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
        }
        return maxProfit2;
    }
}
