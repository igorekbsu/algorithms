package lis;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int i = Arrays.binarySearch(dp, 0, len, n);
            if (i < 0) i = -(i + 1);
            dp[i] = n;
            if (i == len) len++;
        }
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        int[][] c = new int[nums.length + 1][nums.length + 1];
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (sorted[i] == nums[j])
                    c[i + 1][j + 1] = 1 + c[i][j];
                else
                    c[i + 1][j + 1] = Math.max(c[i + 1][j], c[i][j + 1]);
        return c[nums.length][nums.length];
    }
}
