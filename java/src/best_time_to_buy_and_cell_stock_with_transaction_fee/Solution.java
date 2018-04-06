package best_time_to_buy_and_cell_stock_with_transaction_fee;
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int cash = 0, hold = -prices[0];
        for (int price : prices) {
            cash = Math.max(cash, hold + price - fee);
            hold = Math.max(hold, cash - price);
        }
        return cash;
    }
}
