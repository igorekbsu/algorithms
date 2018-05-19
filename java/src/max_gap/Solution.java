package max_gap;
import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] a) {
        Arrays.sort(a);
        int gap = 0;
        for (int i = 1; i < a.length; i++)
            gap = Math.max(gap, a[i] - a[i - 1]);
        return gap;
    }
}
