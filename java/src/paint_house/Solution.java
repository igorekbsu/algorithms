package paint_house;
public class Solution {
    public int minCost(int[][] costs) {
        int r = 0, b = 0, g = 0;
        for (int[] cost : costs) {
            int rr = r, bb = b, gg = g;
            r = cost[0] + Math.min(bb, gg);
            b = cost[1] + Math.min(rr, gg);
            g = cost[2] + Math.min(rr, bb);
        }
        return Math.min(r, Math.min(b, g));
    }
}
