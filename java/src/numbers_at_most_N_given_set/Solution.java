package numbers_at_most_N_given_set;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 133));
    }

    public int atMostNGivenDigitSet(String[] D, int N) {
        String s = String.valueOf(N);
        int len = s.length(), dp[] = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; --i) {
            int n = s.charAt(i) - '0';
            for (String d : D)
                if (Integer.valueOf(d) < n)
                    dp[i] += Math.pow(D.length, len - i - 1);
                else if (Integer.valueOf(d) == n)
                    dp[i] += dp[i + 1];
        }
        for (int i = 1; i < len; ++i)
            dp[0] += Math.pow(D.length, i);
        return dp[0];
    }
}
