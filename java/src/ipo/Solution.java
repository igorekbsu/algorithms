package ipo;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        if(k>=profits.length)
        for (int i = 0; i < k; i++) {
            int maxCapI = -1, maxProfit = -1;
            for (int j = 0; j < capital.length; j++)
                if (profits[j] > maxProfit && capital[j] <= W && capital[j] >= 0) {
                    maxCapI = j;
                    maxProfit = profits[j];
                }
            if (maxCapI == -1) break;
            capital[maxCapI] = -1;
            W += maxProfit;
        }
        return W;
    }
}
