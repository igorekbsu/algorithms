package partition_equal_subset;
public class Solution {
    public static void main(String[] args) {
        int[] a = {43, 42, 20, 86, 5, 5, 64, 77, 92, 94, 7, 4, 28, 42, 67, 97, 93, 85, 53, 41, 22, 86, 26, 45, 100, 57, 19, 94, 83, 29, 36, 100, 24, 36, 62, 38, 97, 86, 10, 86, 76, 69, 73, 31, 53,
                95, 82, 88, 72, 29, 96, 24, 90, 33, 62, 85, 63, 93, 83, 20, 23, 72, 26, 31, 97, 79, 72, 69, 38, 29, 36, 75, 73, 66, 48, 50, 77, 12, 79, 48, 3, 67, 16, 40, 11, 79, 28, 5, 18, 12, 80,
                4, 82, 60, 29, 96, 95, 2, 50, 99};
        System.out.println(new Solution().canPartition(a));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++)
            dp[i][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1])
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[n][sum];
    }
}
