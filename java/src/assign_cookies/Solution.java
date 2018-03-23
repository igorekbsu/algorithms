package assign_cookies;
import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length && j < g.length; i++)
            if (g[j] <= s[i])
                j++;
        return j;
    }
}
