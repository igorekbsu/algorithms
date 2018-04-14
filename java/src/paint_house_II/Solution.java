package paint_house_II;
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int min1 = 0, min2 = 0, index = -1;
        for (int[] cost : costs) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < cost.length; i++) {
                int c = cost[i] + (index != i ? min1 : min2);
                if (c < m1) {
                    m2 = m1; m1 = c; idx = i;
                } else if(c < m2){
                    m2 = c; 
                }
            }
            min1 = m1; min2 = m2; index = idx;
        }
        return min1;
    }
}
