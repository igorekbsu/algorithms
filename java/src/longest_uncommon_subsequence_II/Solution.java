package longest_uncommon_subsequence_II;
public class Solution {
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++)
                if (j != i && isSubsequence(strs[i], strs[j]))
                    break;
            if (j == strs.length)
                maxLen = Math.max(maxLen, strs[i].length());
        }
        return maxLen;
    }

    boolean isSubsequence(String x, String y) {
        if (x.length() > y.length()) return false;
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
}
