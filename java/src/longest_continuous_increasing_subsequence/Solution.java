package longest_continuous_increasing_subsequence;
public class Solution {
    public int findLengthOfLCIS(int[] a) {
        if (a.length == 0) return 0;
        int len = 1, maxLen = 1;
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] < a[i])
                maxLen = Math.max(maxLen, ++len);
            else len = 1;
        return maxLen;
    }
}
