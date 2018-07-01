package freedom_trail;
public class Solution {
    public int findRotateSteps(String ring, String key) {
        return dfs(ring.toCharArray(), key.toCharArray(), 0, 0, new int[ring.length()][key.length()]);
    }

    int dfs(char[] ring, char[] key, int ringIdx, int keyIdx, int[][] dp) {
        if (keyIdx == key.length) return 0;
        if (dp[ringIdx][keyIdx] > 0)
            return dp[ringIdx][keyIdx];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length; i++)
            if (key[keyIdx] == ring[i]) {
                int diff = Math.abs(i - ringIdx);
                int distance = 1 + Math.min(diff, ring.length - diff) + dfs(ring, key, i, keyIdx + 1, dp);
                min = Math.min(distance, min);
            }
        dp[ringIdx][keyIdx] = min;
        return min;
    }

}
