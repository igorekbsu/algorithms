package number_of_longest_increasing_subsequence;
public class Solution {
    public int findNumberOfLIS(int[] a) {
        int n = a.length, r = 0, maxLen = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++)
                if (a[i] > a[j]) {
                    if (len[i] == len[j] + 1)
                        cnt[i] += cnt[j];
                    else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            if (maxLen == len[i])
                r += cnt[i];
            else if (maxLen < len[i]) {
                maxLen = len[i];
                r = cnt[i];
            }
        }
        return r;
    }
}
