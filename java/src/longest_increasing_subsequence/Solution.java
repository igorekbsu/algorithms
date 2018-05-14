package longest_increasing_subsequence;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] a) {
        if (a.length == 0) return 0;
        int dp[] = new int[a.length], lisLen = 1;
        dp[0] = 1;
        for (int i = 1; i < a.length; i++) {
            int maxLen = 1;
            for (int j = 0; j < i; j++)
                if (a[i] > a[j])
                    maxLen = Math.max(maxLen, dp[j] + 1);
            dp[i] = maxLen;
            lisLen = Math.max(maxLen, lisLen);
        }
        return lisLen;
    }
}
