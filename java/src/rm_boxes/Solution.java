package rm_boxes;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeBoxes(new int[]{1, 1, 1}));
    }

    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return rm(boxes, 0, boxes.length - 1, 1, dp);
    }

    int rm(int[] boxes, int lo, int hi, int k, int[][][] dp) {
        if (lo > hi) return 0;
        if (lo == hi) return k * k;
        if (dp[lo][hi][k] > 0) return dp[lo][hi][k];
        int r = rm(boxes, lo + 1, hi, 1, dp) + k * k;
        for (int i = lo + 1; i <= hi; i++)
            if (boxes[lo] == boxes[i])
                r = Math.max(r, rm(boxes, lo + 1, i - 1, 1, dp) + rm(boxes, i, hi, k + 1, dp));
        dp[lo][hi][k] = r;
        return r;
    }
}
