package best_time_to_buy_and_cell_stock;
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            if (price > min)
                profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
