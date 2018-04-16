package interleaving_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()) return false;
        return is(s1, 0, s2, 0, s3, 0, dp);
    }

    boolean is(String s1, int i1, String s2, int i2, String s3, int i3, boolean[][] dp) {
        if (i3 == s3.length()) return true;
        if (dp[i1][i2])
            return false;
        for (int i = 0; i < s1.length() - i1; i++) {
            if (s1.charAt(i1 + i) == s3.charAt(i3 + i)) {
                if (is(s1, i1 + i + 1, s2, i2, s3, i3 + i + 1, dp))
                    return true;
            } else break;
        }
        for (int i = 0; i < s2.length() - i2; i++) {
            if (s2.charAt(i2 + i) == s3.charAt(i3 + i)) {
                if (is(s1, i1, s2, i2 + i + 1, s3, i3 + i + 1, dp))
                    return true;
            } else break;
        }
        dp[i1][i2] = true;
        return false;
    }
}
