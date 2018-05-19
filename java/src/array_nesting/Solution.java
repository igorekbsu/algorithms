package array_nesting;
public class Solution {
    public int arrayNesting(int[] a) {
        int maxLen = 0;
        for (int i = 0; i < a.length; i++) {
            int len = 0;
            for (int j = i; a[j] >= 0; len++) {
                int next = a[j];
                a[j] = -1;
                j = next;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
