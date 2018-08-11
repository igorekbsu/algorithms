package palindrome_partitioning_II;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aab"));
    }

    Map<String, Integer> dp = new HashMap<>();

    public int minCut(String s) {
        if (dp.containsKey(s))
            return dp.get(s);
        if (pal(s))
            return 0;
        int minCut = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++)
            minCut = Math.min(minCut, 1 + minCut(s.substring(0, i)) + minCut(s.substring(i)));
        dp.put(s, minCut);
        return minCut;
    }

    boolean pal(String s) {
        for (int lo = 0, hi = s.length() - 1; lo < hi; lo++, hi--)
            if (s.charAt(lo) != s.charAt(hi))
                return false;
        return true;
    }
}
