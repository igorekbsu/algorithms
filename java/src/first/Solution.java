package first;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numTilings(60));
    }

    public int rotatedDigits(int N) {
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        m.put(1, 1);
        m.put(8, 8);
        m.put(2, 5);
        m.put(5, 2);
        m.put(6, 9);
        m.put(9, 6);
        for (int i = 1; i <= N; i++) {
            Integer rotated = 0, r = null, j = i, order = 1;
            while (j > 0) {
                int d = j % 10;
                r = m.get(d);
                if (r == null) break;
                rotated = order * r + rotated;
                order *= 10;
                j /= 10;
            }
            if (r != null && rotated != i)
                count++;
        }
        return count;
    }

    public String customSortString(String S, String T) {
        int[] f = new int[26];
        for (char c : T.toCharArray())
            f[c - 'a']++;
        StringBuilder custom = new StringBuilder();
        for (char c : S.toCharArray()) {
            for (int i = 0; i < f[c - 'a']; i++)
                custom.append(c);
            f[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < f[i]; j++)
                custom.append((char) ('a' + i));
        return custom.toString();
    }

    public int numTilings(int N) {
        long[] dp = new long[Math.max(3, N + 1)];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= N; i++)
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % 1000000007;
        return (int) dp[N];
    }
}
