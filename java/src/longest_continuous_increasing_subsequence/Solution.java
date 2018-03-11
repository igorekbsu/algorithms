package longest_continuous_increasing_subsequence;
public class Solution {
    public int findLengthOfLCIS(int[] a) {
        if (a.length == 0) return 0;
        int max = 0, len = 1;
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] >= a[i]) {
                max = Math.max(max, len);
                len = 1;
            } else len++;
        return Math.max(max, len);
    }
}
