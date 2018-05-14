package russian_doll_envelopes;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int dp[] = new int[envelopes.length], lis = 1;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxLen = 1;
            for (int j = 0; j < i; j++)
                if (envelopes[i][1] > envelopes[j][1])
                    maxLen = Math.max(maxLen, dp[j] + 1);
            dp[i] = maxLen;
            lis = Math.max(lis, maxLen);
        }
        return lis;
    }
}
